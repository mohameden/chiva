package clinique.controller.securite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LogOutAction extends Action {

	private static final String REQ_PARAM_UN = "login_user";
	public static final String KEY_USER = "UserConnected";
	private static final String FORWARD_ERR = "erreur";

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		String userLogin = request.getParameter(REQ_PARAM_UN);       
		if (userLogin == null) return mapping.findForward(FORWARD_ERR);
		if(request.getSession()!=null)
				{
					request.getSession().invalidate();
				}
		else
		{
			
		}
		return mapping.findForward(FORWARD_ERR);
		
	
	}

}

