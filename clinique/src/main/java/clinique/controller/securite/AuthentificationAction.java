package clinique.controller.securite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import clinique.metier.securite.IAuthentificationBO;
import clinique.model.securite.SecuriteForm;

public class AuthentificationAction extends ActionSupport {

	private static Logger log = Logger.getLogger(AuthentificationAction.class);
	public static final String KEY_USER = "userConnected";
	private static final String FORWARD = "succes";
	private static final String FORWARD_ERR = "erreurConnexion";

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		log.debug("********** Debut execute AuthentificationAction **********");
		try {
			SecuriteForm formulaire = (SecuriteForm) form;
			IAuthentificationBO authentificationBO = (IAuthentificationBO) getWebApplicationContext()
					.getBean(IAuthentificationBO.NAME);
			formulaire = authentificationBO.getUser(formulaire);
			if (formulaire != null) {
				return mapping.findForward(FORWARD);
			} else {
				this.saveErrors(request, authentificationBO.getErrors());
				return mapping.findForward(FORWARD_ERR);
			}
		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward(FORWARD_ERR);

		} finally {
			log.debug("********** Fin execute AuthentificationAction **********");
		}
	}

}
