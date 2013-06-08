import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import clinique.dao.DetailFactureDAO;
import clinique.dao.FactureDAO;
import clinique.impression.pdf.IRecuImpressionBO;
import clinique.mapping.DetailFacture;
import clinique.mapping.Facture;

@Test
public class FactureTest extends AbstractCliniqueTestNGSpringContextTests {
	@Autowired
	private DetailFactureDAO detailFactureDAO;
	@Autowired
	private FactureDAO factureDAO;
	@Autowired
	private IRecuImpressionBO impressionBO;

	public void testDetailFactureDao() throws Throwable {
		Facture facture = factureDAO.getFacture("11201203101418063");
		flush();
		List<DetailFacture> list = detailFactureDAO
				.findDetailFactureByFacture(facture);

		AssertJUnit.assertTrue(list.size() > 1);
	}

	public void testRecuPdf() throws Throwable {
		OutputStream os = new FileOutputStream("d:/recu_test.pdf");
		impressionBO.imprimerPDF("11201304151137182", "ORIGINAL", "sas", os);

	}
}
