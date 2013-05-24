package clinique.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.springframework.web.context.support.HttpRequestHandlerServlet;

public class CliniqueHttpRequestHandlerServlet extends
		HttpRequestHandlerServlet {

	private static final long serialVersionUID = 581657000509250815L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		InitServlet.CHEMIN_ROOT = config.getServletContext().getRealPath("/");
	}
}
