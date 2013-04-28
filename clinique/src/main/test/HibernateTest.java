import java.util.List;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import clinique.dao.ActeurDAO;
import clinique.mapping.Acteur;

@Test
public class HibernateTest {
	public void testDao() {
		List<Acteur> acteures = ActeurDAO.getInstance().listActeures();
		AssertJUnit.assertTrue(acteures.size() > 0);
	}
}
