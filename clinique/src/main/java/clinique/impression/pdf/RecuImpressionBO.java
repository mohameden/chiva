package clinique.impression.pdf;

import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clinique.dao.DetailFactureDAO;
import clinique.dao.FactureDAO;
import clinique.dao.RecuDAO;
import clinique.dao.ReglementDAO;
import clinique.mapping.DetailFacture;
import clinique.mapping.Facture;
import clinique.mapping.Reglement;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.RectangleReadOnly;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

@Service(IRecuImpressionBO.NAME)
public class RecuImpressionBO extends AbstractPdfImpressionBO implements
		IRecuImpressionBO {
	private static final int DETAIL_ORDONATE = 190;
	private static final int TOTAL_ORDONATE = 173;
	private static final int REGLEMENT_ORDONATE = 113;
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
	protected void updateDocMetaInfos(Document doc) {
		super.updateDocMetaInfos(doc);
		doc.setPageSize(new RectangleReadOnly(595, 280));
	}

	@Override
	public void imprimerPDF(String numFacture, String mentionName, String user,
			OutputStream out) {

		Document doc = new Document();
		PdfWriter docWriter = null;
		initializeFonts();

		try {
			docWriter = PdfWriter.getInstance(doc, out);
			updateDocMetaInfos(doc);
			doc.open();
			PdfContentByte cb = docWriter.getDirectContent();

			Facture facture = factureDAO.getFacture(numFacture);
			List<DetailFacture> detailList = detailFactureDAO
					.findDetailFactureByFacture(facture);
			List<Reglement> regList = reglementDAO
					.findReglementsByFacture(facture);

			Mention mention = Mention.findByMention(mentionName);

			List<ReglementPrinter> rList = ReglementPrinter
					.toReglementPrinter(mention
							.getFilteredReglementList(regList));
			List<DetailFacturePrinter> dList = DetailFacturePrinter
					.toDetailPrinter(detailList);
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
			printFirstPages(doc, cb, facture, nbrPage, it, mention);
			printLastPage(user, doc, cb, facture, rList, hList, nbrPage, it,
					mention, detailList);
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
			Iterator<DetailFacturePrinter> it, Mention mention,
			List<DetailFacture> detailList) {
		int y = 0;
		// ecrire la derniere page
		generateFinalLayout(doc, cb, facture, user, mention);
		y = DETAIL_ORDONATE;
		generateDetailList(doc, cb, it, y);
		// start total
		y = TOTAL_ORDONATE;
		generateTotal(doc, cb, y, facture, mention, detailList);
		// start reglement
		y = REGLEMENT_ORDONATE;
		generateReglement(doc, cb, y, rList, facture);
		generateFooter(cb, nbrPage);
	}

	private void printFirstPages(Document doc, PdfContentByte cb,
			Facture facture, int nbrPage, Iterator<DetailFacturePrinter> it,
			Mention mention) {
		int y;
		// ecrire les premières pages
		for (int i = 0; i < nbrPage - 1; i++) {
			generateFirstLayout(doc, cb, facture, mention);
			y = DETAIL_ORDONATE;
			generateDetailList(doc, cb, it, y);
			generateFooter(cb, nbrPage);
			doc.newPage();
		}
	}

	private void generateTotal(Document doc, PdfContentByte cb, int y,
			Facture facture, Mention mention, List<DetailFacture> detailList) {
		DecimalFormat df = new DecimalFormat("0.00");

		createContent(cb, 287 + 76 + 70 - 2, y,
				df.format(mention.getFactureHT(facture, detailList)),
				PdfContentByte.ALIGN_RIGHT);
		double totalTTC = facture.getTotalHT() + facture.getTotalTva();
		createContent(cb, 287 + 76 + 70 * 2 - 2, y, df.format(totalTTC),
				PdfContentByte.ALIGN_RIGHT);
		createContent(cb, 570, y, df.format(facture.getRemise()),
				PdfContentByte.ALIGN_RIGHT);

		// createContent(cb, 570, 160, df.format(facture.getAvance()),
		// PdfContentByte.ALIGN_RIGHT);
		// createContent(cb, 570, 148, df.format(facture.getNetApayer()),
		// PdfContentByte.ALIGN_RIGHT);
	}

	protected void generateFinalLayout(Document doc, PdfContentByte cb,
			Facture facture, String user, Mention mention) {

		try {

			generateHeader(doc, cb);

			generateFactureInformations(cb, facture, mention);

			generateLeftDetailTable(cb);

			generateTotalTable(cb);
			//
			generateReglementTable(cb);
			//
			generatePrinterName(cb, user);

		}

		catch (DocumentException dex) {
			dex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void generateFirstLayout(Document doc, PdfContentByte cb,
			Facture facture, Mention mention) {

		try {

			generateHeader(doc, cb);

			generateFactureInformations(cb, facture, mention);

			generateCompleteDetailTable(cb);

		}

		catch (DocumentException dex) {
			dex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void generatePrinterName(PdfContentByte cb, String user) {
		createSmall(cb, 72 - getA5XMargin(), 30, "* Reçu imprimée par " + user);
	}

	private void generateTotalTable(PdfContentByte cb) {
		float x0 = 287;
		float w = 286;
		float y1 = 145;
		float h1 = 55;
		cb.rectangle(x0, y1, w, h1);

		cb.moveTo(x0 + 76, y1);
		// cb.moveTo(x0 + 76, 170);
		cb.lineTo(x0 + 76, 200);
		cb.moveTo(x0 + 76 + 70, y1);
		cb.lineTo(x0 + 76 + 70, 200);
		cb.moveTo(x0 + 76 + 70 * 2, y1);
		cb.lineTo(x0 + 76 + 70 * 2, 200);

		cb.moveTo(x0, 185);
		cb.lineTo(x0 + w, 185);
		// cb.moveTo(x0, 170);
		// cb.lineTo(x0 + w, 170);
		cb.stroke();

		createHeadings(cb, x0 + 2, 188, "LIBELLE");
		createHeadings(cb, x0 + 2 + 76, 188, "TOTAL HT");
		createHeadings(cb, x0 + 2 + 76 + 70, 188, "TOTAL TTC");
		createHeadings(cb, x0 + 2 + 76 + 70 * 2, 188, "REMISE");
		// createHeadings(cb, x0 + 2, 160, "AVANCE");
		// createHeadings(cb, x0 + 2, 148, "NET A PAYER");
	}

	private void generateReglementTable(PdfContentByte cb) {
		float x0 = 287;
		float w = 286;
		float y1 = 40;
		float h1 = 100;
		cb.rectangle(x0, y1, w, h1);
		cb.moveTo(x0, 125);
		cb.lineTo(x0 + w, 125);

		cb.moveTo(x0 + 76, 85);
		cb.lineTo(x0 + 76, 140);
		cb.moveTo(x0 + 76 + 70, 85);
		cb.lineTo(x0 + 76 + 70, 140);
		cb.moveTo(x0 + 76 + 70 * 2, 85);
		cb.lineTo(x0 + 76 + 70 * 2, 140);

		cb.moveTo(x0, 85);
		cb.lineTo(x0 + w, 85);
		cb.moveTo(x0, 55);
		cb.lineTo(x0 + w, 55);
		cb.stroke();

		createHeadings(cb, x0 + 2, 128, "MODE");
		createHeadings(cb, x0 + 2 + 76, 128, "DRG");
		createHeadings(cb, x0 + 2 + 76 + 70, 128, "JUSTIF");
		createHeadings(cb, x0 + 2 + 76 + 70 * 2, 128, "MONTANT");
		createHeadings(cb, x0 + 2, 73, "TOTAL REGLEMENT");
		createHeadings(cb, x0 + 2, 58, "RESTE A PAYER");
		createHeadings(cb, x0 + 2, 43, "Le Caissier");
	}

	private float generateLeftDetailTable(PdfContentByte cb) {
		float x0 = 72 - getA5XMargin();
		float y0 = 40;
		float w = 210 + getA5XMargin();
		float h = 160;
		cb.rectangle(x0, y0, w, h);
		cb.stroke();
		return w;
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

	private void generateFactureInformations(PdfContentByte cb,
			Facture facture, Mention mention) {
		createHeadings(cb, 400, 738 - getA5YAdjustement() + getA5XMargin(),
				mention.getMention());
		createTitle(cb, 200, 738 - getA5YAdjustement() + getA5XMargin(),
				"RECU N°: " + facture.getFactureId());
		createHeadings(cb, 72 - getA5XMargin(), 718 - getA5YAdjustement()
				+ getA5XMargin(), "PATIENT : "
				+ facture.getPatient().getPatientId());
		createHeadings(cb, 180, 718 - getA5YAdjustement() + getA5XMargin(),
				facture.getPatient().getNom());
		createHeadings(cb, 400, 718 - getA5YAdjustement() + getA5XMargin(),
				"DU: " + facture.getDateFact());
	}

	@Override
	protected int getA5YAdjustement() {
		return 560;
	}

	@Override
	protected int getA5XMargin() {
		return 50;
	}

	private void generateReglement(Document doc, PdfContentByte cb, int y,
			List<ReglementPrinter> list, Facture facture) {
		DecimalFormat df = new DecimalFormat("0.00");
		double totalReglement = 0.0;
		for (ReglementPrinter reglementPrinter : list) {
			createContent(cb, 287 + 2, y, reglementPrinter.getModeReglement(),
					PdfContentByte.ALIGN_LEFT);
			createContent(cb, 287 + 2 + 76, y, reglementPrinter.getDrg(),
					PdfContentByte.ALIGN_LEFT);
			createContent(cb, 287 + 2 + 76 + 70, y,
					reglementPrinter.getDescription(),
					PdfContentByte.ALIGN_LEFT);
			createContent(cb, 570, y, df.format(reglementPrinter.getMontant()),
					PdfContentByte.ALIGN_RIGHT);
			y = y - 15;
			totalReglement += reglementPrinter.getMontant();
		}

		createContent(cb, 570, 73, df.format(totalReglement),
				PdfContentByte.ALIGN_RIGHT);
		createContent(cb, 570, 58,
				df.format(facture.getNetApayer() - totalReglement),
				PdfContentByte.ALIGN_RIGHT);

	}

	private void generateDetailList(Document doc, PdfContentByte cb,
			Iterator<DetailFacturePrinter> it, int y) {
		try {
			int i = 0;
			DecimalFormat df = new DecimalFormat("0.00");
			while (it.hasNext() && i < 34) {
				i++;
				DetailFacturePrinter facturePrinter = it.next();
				if (facturePrinter.isActe()) {
					createContent(cb, 24, y, facturePrinter.toRecuString(),
							PdfContentByte.ALIGN_LEFT);
					createContent(cb, 200, y,
							String.valueOf(facturePrinter.getNbr()),
							PdfContentByte.ALIGN_RIGHT);
					createContent(cb, 220, y, "/", PdfContentByte.ALIGN_RIGHT);
					createContent(cb, 280, y,
							df.format(facturePrinter.getTarif()),
							PdfContentByte.ALIGN_RIGHT);
				} else {
					createHeadings(cb, 44, y, facturePrinter.getActeName());
				}
				y = y - 15;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	enum Mention {
		ORIGINAL("Original") {
			@Override
			public double getFactureHT(Facture facture,
					List<DetailFacture> detailList) {
				return facture.getTotalHT();
			}

			@Override
			public List<Reglement> getFilteredReglementList(
					List<Reglement> reglements) {
				return reglements;
			}
		},
		COPIE_1("Copie 1") {
			@Override
			public double getFactureHT(Facture facture,
					List<DetailFacture> detailList) {
				double result = 0d;
				for (DetailFacture detail : detailList) {
					result += detail.getPrixReel();
				}
				return result;
			}

			@Override
			public List<Reglement> getFilteredReglementList(
					List<Reglement> reglements) {
				Iterator<Reglement> iterator = reglements.iterator();
				while (iterator.hasNext()) {
					if (!"cash".equalsIgnoreCase(iterator.next()
							.getTypePayement().getTypePayement())) {
						iterator.remove();
					}
				}
				return reglements;
			}
		},
		COPIE_2("Copie 2") {
			@Override
			public double getFactureHT(Facture facture,
					List<DetailFacture> detailList) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public List<Reglement> getFilteredReglementList(
					List<Reglement> reglements) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		private final String mention;

		private Mention(String mention) {
			this.mention = mention;
		}

		public String getMention() {
			return mention;
		}

		public abstract double getFactureHT(Facture facture,
				List<DetailFacture> detailList);

		public abstract List<Reglement> getFilteredReglementList(
				List<Reglement> reglements);

		public static Mention findByMention(String mention) {
			for (Mention element : Mention.values()) {
				if (element.getMention().equals(mention)) {
					return element;
				}

			}
			throw new IllegalArgumentException("Mention Inconnu : " + mention);

		}
	}

}