package clinique.impression.pdf;

import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clinique.dao.DetailFactureDAO;
import clinique.dao.FactureDAO;
import clinique.dao.RecuDAO;
import clinique.dao.ReglementDAO;
import clinique.mapping.DetailFacture;
import clinique.mapping.Facture;
import clinique.mapping.HasDetailFactureInfo;
import clinique.mapping.Reglement;
import clinique.utils.UtilDate;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

@Service(IFactureImpressionBO.NAME)
public class FactureImpressionBO extends AbstractPdfImpressionBO implements
		IFactureImpressionBO {
	private static final int DETAIL_ORDONATE = 638;
	private static final int TOTAL_ORDONATE = 318;
	private static final int REGLEMENT_ORDONATE = 238;
	private static final int NBR_OF_LINE_BY_FINAL_PAGE = 17;
	private static final int NBR_OF_LINE_BY_COMPLETE_PAGE = 34;

	@Autowired
	private RecuDAO recuDAO;
	@Autowired
	private FactureDAO factureDAO;
	@Autowired
	private DetailFactureDAO detailFactureDAO;
	@Autowired
	private ReglementDAO reglementDAO;

	@Override
	public void imprimerPDF(String numFacture, String mention, String user,
			OutputStream out) {

		Document doc = new Document();
		PdfWriter docWriter = null;
		initializeFonts();

		try {
			docWriter = PdfWriter.getInstance(doc, out);
			doc.addAuthor("User");
			doc.addCreationDate();
			doc.addProducer();
			doc.addCreator("Clinique Chiva");
			doc.addTitle("Facture");
			doc.setPageSize(PageSize.A4);

			doc.open();
			PdfContentByte cb = docWriter.getDirectContent();

			Facture facture = factureDAO.getFacture(numFacture);
			List<DetailFacture> detailList = detailFactureDAO
					.findDetailFactureByFacture(facture);
			List<Reglement> regList = reglementDAO
					.findReglementsByFacture(facture);
			List<ReglementPrinter> rList = ReglementPrinter
					.toReglementPrinter(regList);
			List<HasDetailFactureInfo> details = new ArrayList<HasDetailFactureInfo>();
			details.addAll(detailList);
			List<DetailFacturePrinter> dList = DetailFacturePrinter
					.toDetailPrinter(details);
			List<HospitalisationPrinter> hList = initHospitalisations(detailList);
			int nbrOfLineToPrint = dList.size();
			int nbrPage = nbrOfLineToPrint / NBR_OF_LINE_BY_COMPLETE_PAGE;
			int reste = nbrOfLineToPrint % NBR_OF_LINE_BY_COMPLETE_PAGE;
			if (reste > getNbrOfLineByFinalPage()) {
				nbrPage += 2;

			} else {
				nbrPage += 1;
			}
			Iterator<DetailFacturePrinter> it = dList.iterator();
			printFirstPages(doc, cb, facture, nbrPage, it);
			printLastPage(user, doc, cb, facture, rList, hList, nbrPage, it);
		} catch (Throwable ex) {
			ex.printStackTrace();
		} finally {
			if (doc != null) {
				doc.close();
			}
			if (docWriter != null) {
				docWriter.close();
			}
		}
	}

	protected List<HospitalisationPrinter> initHospitalisations(
			List<DetailFacture> detailList) {
		return null;
	}

	protected int getNbrOfLineByFinalPage() {
		return NBR_OF_LINE_BY_FINAL_PAGE;
	}

	protected void printLastPage(String user, Document doc, PdfContentByte cb,
			Facture facture, List<ReglementPrinter> rList,
			List<HospitalisationPrinter> hList, int nbrPage,
			Iterator<DetailFacturePrinter> it) {
		int y = 0;
		// ecrire la derniere page
		generateFinalLayout(doc, cb, facture, user);
		y = DETAIL_ORDONATE;
		generateDetailList(doc, cb, it, y);
		// start total
		y = TOTAL_ORDONATE;
		generateTotal(doc, cb, y, facture);
		// start reglement
		y = REGLEMENT_ORDONATE;
		generateReglement(doc, cb, y, rList);
		generateFooter(cb, nbrPage);
	}

	private void printFirstPages(Document doc, PdfContentByte cb,
			Facture facture, int nbrPage, Iterator<DetailFacturePrinter> it) {
		int y;
		// ecrire les premières pages
		for (int i = 0; i < nbrPage - 1; i++) {
			generateFirstLayout(doc, cb, facture);
			y = DETAIL_ORDONATE;
			generateDetailList(doc, cb, it, y);
			generateFooter(cb, nbrPage);
			doc.newPage();
		}
	}

	private void generateTotal(Document doc, PdfContentByte cb, int y,
			Facture facture) {
		DecimalFormat df = new DecimalFormat("0.00");

		createContent(cb, 74 + 64 - 4, y, df.format(facture.getTotalHT()),
				PdfContentByte.ALIGN_RIGHT);
		createContent(cb, 74 + 2 * 64 - 4, y, df.format(facture.getTotalTva()),
				PdfContentByte.ALIGN_RIGHT);
		double totalTTC = facture.getTotalHT() + facture.getTotalTva();
		createContent(cb, 74 + 3 * 64 - 4, y, df.format(totalTTC),
				PdfContentByte.ALIGN_RIGHT);
		createContent(cb, 74 + 4 * 64 - 4, y,
				df.format(facture.getTauxRemise()), PdfContentByte.ALIGN_RIGHT);
		createContent(cb, 74 + 5 * 64 - 4, y,
				df.format(facture.getRemiseCash()), PdfContentByte.ALIGN_RIGHT);
		createContent(cb, 74 + 6 * 64 - 4, y, df.format(facture.getRemise()),
				PdfContentByte.ALIGN_RIGHT);
		createContent(cb, 72 + 451 - 2, y, df.format(facture.getAvance()),
				PdfContentByte.ALIGN_RIGHT);
		createContent(cb, 72 + 451 - 2, y - 20,
				df.format(facture.getNetApayer()), PdfContentByte.ALIGN_RIGHT);

	}

	protected void generateFinalLayout(Document doc, PdfContentByte cb,
			Facture facture, String user) {

		try {

			generateHeader(doc, cb);

			generateFactureInformations(cb, facture);

			generateFinalDetailTable(cb);

			generateTotalTable(cb);

			generateReglementTable(cb);

			generatePrinterName(cb, user);

		}

		catch (DocumentException dex) {
			dex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void generateFirstLayout(Document doc, PdfContentByte cb,
			Facture facture) {

		try {

			generateHeader(doc, cb);

			generateFactureInformations(cb, facture);

			generateCompleteDetailTable(cb);

		}

		catch (DocumentException dex) {
			dex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void generatePrinterName(PdfContentByte cb, String user) {
		createHeadings(cb, 72, 140, "* Facture imprimée par " + user);
	}

	private void generateReglementTable(PdfContentByte cb) {
		float x0 = 72;
		float w = 451;
		float y2 = 170;
		float h2 = 100;
		cb.rectangle(x0, y2, w, h2);
		cb.moveTo(x0, 250);
		cb.lineTo(x0 + w, 250);
		cb.moveTo(172, y2);
		cb.lineTo(172, y2 + h2);
		cb.moveTo(372, y2);
		cb.lineTo(372, y2 + h2);
		cb.moveTo(472, y2);
		cb.lineTo(472, y2 + h2);
		cb.stroke();

		createHeadings(cb, 74, 253, "MODE REGLEMENT");
		createHeadings(cb, 174, 253, "DESCRIPTION");
		createHeadings(cb, 374, 253, "DATE REGLEMENT");
		createHeadings(cb, 474, 253, "MONTANT");
	}

	private void generateTotalTable(PdfContentByte cb) {
		float x0 = 72;
		float w = 451;
		float y1 = 310;
		float h1 = 60;
		cb.rectangle(x0, y1 - 20, w, h1 + 20);
		cb.moveTo(x0, 330);
		cb.lineTo(x0 + w, 330);
		cb.moveTo(136, y1);
		cb.lineTo(136, y1 + h1);
		cb.moveTo(200, y1);
		cb.lineTo(200, y1 + h1);
		cb.moveTo(264, y1);
		cb.lineTo(264, y1 + h1);
		cb.moveTo(328, y1);
		cb.lineTo(328, y1 + h1);
		cb.moveTo(392, y1);
		cb.lineTo(392, y1 + h1);
		cb.moveTo(456, y1);
		cb.lineTo(456, y1 + h1);
		cb.moveTo(x0, 310);
		cb.lineTo(x0 + w, 310);
		cb.stroke();

		createHeadings(cb, 74, 333, "TOTAL HT");
		createHeadings(cb, 74 + 64, 333, "TOTAL TVA");
		createHeadings(cb, 74 + 2 * 64, 333, "TOTAL TTC");
		createHeadings(cb, 74 + 3 * 64, 348, "TAUX REMISE");
		createHeadings(cb, 74 + 3 * 64, 333, "/QPC %");
		createHeadings(cb, 74 + 4 * 64, 348, "TAUX REMISE");
		createHeadings(cb, 74 + 4 * 64, 333, "CASH");
		createHeadings(cb, 74 + 5 * 64, 348, "MONTANT");
		createHeadings(cb, 74 + 5 * 64, 333, "REMISE");
		createHeadings(cb, 74 + 6 * 64, 333, "AVANCE");
		createHeadings(cb, 74 + 2 * 64, 293, "NET A PAYER");
	}

	// float x0 = 72;
	// float y0 = 390; 280

	// float x0 = 72;
	// float y1 = 310;
	// float h1 = 60;

	private float generateFinalDetailTable(PdfContentByte cb) {
		float x0 = 72;
		float y0 = getFinalDetailTableOrdonnate();
		float w = 451;
		float h = getFinalDetailTableHeight();
		cb.rectangle(x0, y0, w, h);
		cb.moveTo(x0, 650);
		cb.lineTo(x0 + w, 650);
		cb.moveTo(431, y0);
		cb.lineTo(431, y0 + h);
		cb.moveTo(453, y0);
		cb.lineTo(453, y0 + h);
		cb.stroke();

		createHeadings(cb, 74, 653, "ACTE");
		createHeadings(cb, 433, 653, "NBR");
		createHeadings(cb, 455, 653, "TARIF");
		return w;
	}

	protected int getFinalDetailTableOrdonnate() {
		return 390;
	}

	protected int getFinalDetailTableHeight() {
		return 280;

	}

	private float generateCompleteDetailTable(PdfContentByte cb) {
		float x0 = 72;
		float y0 = 140;
		float w = 451;
		float h = 530;
		cb.rectangle(x0, y0, w, h);
		cb.moveTo(x0, 650);
		cb.lineTo(x0 + w, 650);
		cb.moveTo(431, y0);
		cb.lineTo(431, y0 + h);
		cb.moveTo(453, y0);
		cb.lineTo(453, y0 + h);
		cb.stroke();

		createHeadings(cb, 74, 653, "ACTE");
		createHeadings(cb, 433, 653, "NBR");
		createHeadings(cb, 455, 653, "TARIF");
		return w;
	}

	private void generateFactureInformations(PdfContentByte cb, Facture facture) {
		createHeadings(cb, 350, 753, facture.getFactureFlagType()
				.getPrintName());
		createHeadings(cb, 72, 718, "FACTURE N°: " + facture.getFactureId());
		createHeadings(cb, 72, 703, "NUM PATIENT : "
				+ facture.getPatient().getPatientId());
		createHeadings(cb, 72, 688, "NOM PRENOM : "
				+ facture.getPatient().getNom());
		createHeadings(cb, 250, 718, "DU: " + facture.getDateFact());
	}

	private void generateReglement(Document doc, PdfContentByte cb, int y,
			List<ReglementPrinter> list) {
		DecimalFormat df = new DecimalFormat("0.00");
		for (ReglementPrinter reglementPrinter : list) {
			createContent(cb, 74, y, reglementPrinter.getModeReglement(),
					PdfContentByte.ALIGN_LEFT);
			createContent(cb, 174, y, reglementPrinter.getDescription(),
					PdfContentByte.ALIGN_LEFT);
			String date = StringUtils.EMPTY;
			try {
				date = UtilDate.getInstance().getFormatDate(
						reglementPrinter.getDateReglement(), "yyyy-MM-dd");
			} catch (Exception e) {
			}
			createContent(cb, 374, y, date, PdfContentByte.ALIGN_LEFT);

			createContent(cb, 521, y, df.format(reglementPrinter.getMontant()),
					PdfContentByte.ALIGN_RIGHT);
			y = y - 15;
		}

	}

	private void generateDetailList(Document doc, PdfContentByte cb,
			Iterator<DetailFacturePrinter> it, int y) {
		DecimalFormat df = new DecimalFormat("0.00");

		try {
			int i = 0;
			while (it.hasNext() && i < 34) {
				i++;
				DetailFacturePrinter facturePrinter = it.next();
				if (facturePrinter.isActe()) {
					createContent(cb, 80, y, facturePrinter.getActeName(),
							PdfContentByte.ALIGN_LEFT);

					createContent(cb, 451, y,
							String.valueOf(facturePrinter.getNbr()),
							PdfContentByte.ALIGN_RIGHT);
					createContent(cb, 521, y,
							df.format(facturePrinter.getTarif()),
							PdfContentByte.ALIGN_RIGHT);
				} else {
					createContent(cb, 74, y, facturePrinter.getActeName(),
							PdfContentByte.ALIGN_LEFT);
				}
				y = y - 15;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}