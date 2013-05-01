package clinique.metier.securite;

import org.apache.struts.action.ActionMessages;

import clinique.mapping.User;
import clinique.model.securite.SecuriteForm;

public interface AuthentificationBO {
	String NAME = "AuthentificationBO";

	public User getUser(SecuriteForm formulaire) throws Exception;

	public void create(User user);

	ActionMessages getErrors();

}
