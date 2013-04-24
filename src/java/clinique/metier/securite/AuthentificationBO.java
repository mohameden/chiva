package clinique.metier.securite;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMessages;

import clinique.dao.SessionFactoryUtil;
import clinique.dao.UserDAO;
import clinique.mapping.User;
import clinique.model.securite.SecuriteForm;

public class AuthentificationBO {
	
	private static Logger log = Logger.getLogger(AuthentificationBO.class);
    
	private ActionMessages errors=new ActionMessages();

	public ActionMessages getErrors() {
		return errors;
	}

	public void setErrors(ActionMessages errors) {
		this.errors = errors;
	}
	
	
	
	
		public User getUser(SecuriteForm formulaire) throws Exception
		{
	    log.debug("********** Debut getUser AuthentificationBO **********");
		try
		{
		    User user=UserDAO.getInstance().getUserByLoginEtPassword(formulaire.getLoginUser(),formulaire.getPassword());
		    if(user==null)
		    {
		    	ActionError error = new ActionError("User.Incorrect");
				errors.add("User.Incorrect", error);
		    }
		    return user;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		}
		finally
		   {
			   //SessionFactoryUtil.getInstance().close();
			   log.debug("********** Fin getUser AuthentificationBO **********");
		   }
		}

}
