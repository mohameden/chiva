package clinique.impression.pdf;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import clinique.metier.TransactionalBO;
import clinique.servlets.InitServlet;
import clinique.utils.UtilDate;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;

public abstract class AbstractPdfImpressionBO extends TransactionalBO {

	protected BaseFont bfBold;
	protected BaseFont bf;
	private int pageNumber = 0;

	protected void updateDocMetaInfos(Document doc) {
		doc.addAuthor("User");
		doc.addCreationDate();
		doc.addProducer();
		doc.addCreator("Clinique Chiva");
		doc.setPageSize(PageSize.A4);
	}

	protected void generateFooter(PdfContentByte cb, int totalPages) {
		cb.moveTo(72 - getA5XMargin(), 72 - getA5XMargin());
		cb.lineTo(523 + getA5XMargin(), 72 - getA5XMargin());
		cb.stroke();
		printFooterName(cb);
		printFooterDate(cb);
		printPageNumber(cb, totalPages);
	}

	protected void generateHeader(Document doc, PdfContentByte cb)
			throws BadElementException, MalformedURLException, IOException,
			DocumentException {
		cb.setLineWidth(1f);
		// add the images
		String logoPath = InitServlet.CHEMIN_ROOT + "\\images\\logopdf.jpg";
		// String logoPath = "d:/logopdf.jpg";
		Image companyLogo = Image.getInstance(logoPath);
		companyLogo.setAbsolutePosition(462 + getA5XMargin(), 720
				- getA5YAdjustement() + getA5XMargin());
		companyLogo.scalePercent(10);
		doc.add(companyLogo);

		// Invoice Header box Text Headings
		createHeadings(cb, 72 - getA5XMargin(), 768 - getA5YAdjustement()
				+ getA5XMargin(), "CLINIQUE CHIVA");
		createHeadings(cb, 82 - getA5XMargin(), 753 - getA5YAdjustement()
				+ getA5XMargin(), "ZRA N° 54");
		createHeadings(cb, 72 - getA5XMargin(), 738 - getA5YAdjustement()
				+ getA5XMargin(), "Tel: 525 80 80 Fax: 525 34 35");
	}

	protected int getA5YAdjustement() {
		return 0;
	}

	protected int getA5XMargin() {
		return 0;
	}

	protected void createHeadings(PdfContentByte cb, float x, float y,
			String text) {

		cb.beginText();
		cb.setFontAndSize(bfBold, 8);
		cb.setTextMatrix(x, y);
		cb.showText(text.trim());
		cb.endText();

	}

	protected void createTitle(PdfContentByte cb, float x, float y, String text) {

		cb.beginText();
		cb.setFontAndSize(bfBold, 12);
		cb.setTextMatrix(x, y);
		cb.showText(text.trim());
		cb.endText();

	}

	protected void createSmall(PdfContentByte cb, float x, float y, String text) {

		cb.beginText();
		cb.setFontAndSize(bfBold, 6);
		cb.setTextMatrix(x, y);
		cb.showText(text.trim());
		cb.endText();

	}

	private void printPageNumber(PdfContentByte cb, int totalPages) {

		pageNumber++;
		cb.beginText();
		cb.setFontAndSize(bfBold, 8);
		cb.showTextAligned(PdfContentByte.ALIGN_RIGHT, "Page " + pageNumber
				+ "/" + totalPages, 523 + getA5XMargin(), 65 - getA5XMargin(),
				0);
		cb.endText();

	}

	private void printFooterDate(PdfContentByte cb) {

		cb.beginText();
		cb.setFontAndSize(bfBold, 8);
		String dateFacture = UtilDate.getFormatDateFacture(new Date());
		cb.showTextAligned(PdfContentByte.ALIGN_CENTER, dateFacture, 298,
				65 - getA5XMargin(), 0);
		cb.endText();
	}

	private void printFooterName(PdfContentByte cb) {

		cb.beginText();
		cb.setFontAndSize(bfBold, 8);
		cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "CLINIQUE CHIVA",
				72 - getA5XMargin(), 65 - getA5XMargin(), 0);
		cb.endText();

	}

	protected void createContent(PdfContentByte cb, float x, float y,
			String text, int align) {

		cb.beginText();
		cb.setFontAndSize(bf, 8);
		if (StringUtils.isEmpty(text)) {
			text = StringUtils.EMPTY;
		}
		cb.showTextAligned(align, text.trim(), x, y, 0);
		cb.endText();

	}

	protected void initializeFonts() {

		try {
			bfBold = BaseFont.createFont(BaseFont.HELVETICA_BOLD,
					BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252,
					BaseFont.NOT_EMBEDDED);

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}