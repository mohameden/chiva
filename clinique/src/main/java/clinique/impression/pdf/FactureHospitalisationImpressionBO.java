package clinique.impression.pdf;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import clinique.mapping.DetailFacture;
import clinique.mapping.Facture;
import clinique.utils.UtilDate;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfContentByte;

@Service(IFactureHospitalisationImpressionBO.NAME)
public class FactureHospitalisationImpressionBO extends FactureImpressionBO
		implements IFactureHospitalisationImpressionBO {
	@Override
	protected int getNbrOfLineByFinalPage() {
		return 10;
	}

	@Override
	protected List<HospitalisationPrinter> initHospitalisations(
			List<DetailFacture> detailList) {
		return HospitalisationPrinter.toHospitalisationPrinter(detailList);
	}

	@Override
	protected void generateFinalLayout(Document doc, PdfContentByte cb,
			Facture facture, String user) {
		super.generateFinalLayout(doc, cb, facture, user);
		generateHospitalistionTable(doc, cb);
	}

	private void generateHospitalistionTable(Document doc, PdfContentByte cb) {
		float x0 = 72;
		float w = 451;
		float y = 390;
		float h = 100;
		cb.rectangle(x0, y, w, h);
		cb.moveTo(x0, 250);
		cb.lineTo(x0 + w, 250);
		cb.moveTo(x0 + 251, y);
		cb.lineTo(x0 + 251, y + h);
		cb.moveTo(x0 + 251 + 100, y);
		cb.lineTo(x0 + 251 + 100, y + h);
		cb.stroke();

		createHeadings(cb, 74, 473, "CHAMBRE");
		createHeadings(cb, x0 + 253, 473, "DATE ENTREE");
		createHeadings(cb, x0 + 353, 473, "DATE SORTIE");
	}

	@Override
	protected int getFinalDetailTableOrdonnate() {
		return 510;
	}

	@Override
	protected int getFinalDetailTableHeight() {
		return 160;
	}

	@Override
	protected void printLastPage(String user, Document doc, PdfContentByte cb,
			Facture facture, List<ReglementPrinter> rList,
			List<HospitalisationPrinter> hList, int nbrPage,
			Iterator<DetailFacturePrinter> it) {
		super.printLastPage(user, doc, cb, facture, rList, hList, nbrPage, it);
		int y = 458;
		generateHospitalisation(doc, cb, y, hList);
	}

	private void generateHospitalisation(Document doc, PdfContentByte cb,
			int y, List<HospitalisationPrinter> list) {
		for (HospitalisationPrinter hospitalisationPrinter : list) {
			createContent(cb, 74, y, hospitalisationPrinter.getChambre(),
					PdfContentByte.ALIGN_LEFT);
			String dateEntree = StringUtils.EMPTY;
			String dateSortie = StringUtils.EMPTY;
			try {
				dateEntree = UtilDate.getInstance().getFormatDate(
						hospitalisationPrinter.getDateEntree(), "yyyy-MM-dd");
				dateSortie = UtilDate.getInstance().getFormatDate(
						hospitalisationPrinter.getDateSortie(), "yyyy-MM-dd");
			} catch (Exception e) {
			}
			createContent(cb, 374, y, dateEntree, PdfContentByte.ALIGN_LEFT);
			createContent(cb, 374, y, dateSortie, PdfContentByte.ALIGN_LEFT);
			y = y - 15;
		}
	}
}