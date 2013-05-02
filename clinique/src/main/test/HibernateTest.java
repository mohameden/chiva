import org.springframework.beans.factory.annotation.Autowired;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import clinique.dao.ProfilDAO;
import clinique.dao.UserDAO;
import clinique.mapping.Profil;
import clinique.mapping.User;
import clinique.metier.securite.IAuthentificationBO;

@Test
public class HibernateTest extends AbstractCliniqueTestNGSpringContextTests {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private ProfilDAO profilDAO;
	@Autowired
	private IAuthentificationBO authentificationBO;

	public void testUserDao() throws Throwable {
		User user = userDAO.getUser(1);
		AssertJUnit.assertEquals("Tolba", user.getLogin());
		User user2 = new User();
		Profil profile = new Profil();
		profile.setNomProfil("ppp");
		profile.setOperateur("ppp");
		profile.setStatut("ppp");
		profile.setProfilId(201);
		profilDAO.create(profile);
		flush();
		user2.setLogin("kmo");
		user2.setPassword("password");
		user2.setStatut("3");
		user2.setOperateur("status");
		user2.setProfil(profile);
		authentificationBO.create(user2);
		flush();

		// SecuriteForm formulaire = new SecuriteForm();
		// formulaire.setLoginUser("kmo");
		// formulaire.setPassword("password");
		// User dbUser = authentificationBO.getUser(formulaire);
		// AssertJUnit.assertEquals("kmo", dbUser.getLogin());
	}
}
