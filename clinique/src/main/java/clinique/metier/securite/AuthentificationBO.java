package clinique.metier.securite;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clinique.dao.UserDAO;
import clinique.mapping.User;
import clinique.metier.TransactionalBO;
import clinique.model.securite.SecuriteForm;

@Service(AuthentificationBO.NAME)
public class AuthentificationBO extends TransactionalBO {
	public static final String NAME = "AuthentificationBO";
	@Autowired
	private UserDAO userDAO;

	private ActionMessages errors = new ActionMessages();

	public ActionMessages getErrors() {
		return errors;
	}

	public void setErrors(ActionMessages errors) {
		this.errors = errors;
	}

	public User getUser(SecuriteForm formulaire) throws Exception {
		User user = userDAO.getUserByLoginEtPassword(formulaire.getLoginUser(),
				formulaire.getPassword());
		if (user == null) {
			ActionError error = new ActionError("User.Incorrect");
			errors.add("User.Incorrect", error);
		}
		return user;
	}

	public void create(User user) {
		userDAO.create(user);
	}

}
