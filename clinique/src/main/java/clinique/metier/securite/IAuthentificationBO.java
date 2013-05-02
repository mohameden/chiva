package clinique.metier.securite;

import org.apache.struts.action.ActionMessages;

import clinique.mapping.User;
import clinique.model.securite.SecuriteForm;

public interface IAuthentificationBO {

	public static final String NAME = "IAuthentificationBO";

	public abstract ActionMessages getErrors();

	public abstract void setErrors(ActionMessages errors);

	public abstract SecuriteForm getUser(SecuriteForm formulaire) throws Exception;

	public abstract void create(User user);

}