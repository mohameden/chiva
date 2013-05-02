package clinique.metier.securite;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clinique.dao.UserDAO;
import clinique.mapping.User;
import clinique.metier.TransactionalBO;
import clinique.model.securite.SecuriteForm;

@Service(IAuthentificationBO.NAME)
public class AuthentificationBO extends TransactionalBO implements
		IAuthentificationBO {
	@Autowired
	private UserDAO userDAO;

	private ActionMessages errors = new ActionMessages();

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.securite.IAuthentificationBO#getErrors()
	 */
	@Override
	public ActionMessages getErrors() {
		return errors;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.securite.IAuthentificationBO#setErrors(org.apache.struts
	 * .action.ActionMessages)
	 */
	@Override
	public void setErrors(ActionMessages errors) {
		this.errors = errors;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.securite.IAuthentificationBO#getUser(clinique.model.securite
	 * .SecuriteForm)
	 */
	@Override
	public SecuriteForm getUser(SecuriteForm formulaire) throws Exception {
		User user = userDAO.getUserByLoginEtPassword(formulaire.getLoginUser(),
				formulaire.getPassword());
		if (user == null) {
			ActionError error = new ActionError("User.Incorrect");
			errors.add("User.Incorrect", error);
			return null;
		}
		formulaire.setLoginUser(user.getLogin());
		formulaire.setProfil(user.getProfil().getNomProfil());

		return formulaire;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.securite.IAuthentificationBO#create(clinique.mapping.
	 * User)
	 */
	@Override
	public void create(User user) {
		userDAO.create(user);
	}

}
