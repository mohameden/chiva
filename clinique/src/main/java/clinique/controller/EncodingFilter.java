package clinique.controller;


	import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

	 public class EncodingFilter implements javax.servlet.Filter {
	  private String encoding;
	  private static final List<String> EXEPTION_NETOYAGE = Arrays.asList(new String[]{"userConnected"});
	  public void init(FilterConfig filterConfig) throws ServletException {
	   this.encoding = filterConfig.getInitParameter("encoding");
	  }
	  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
	   request.setCharacterEncoding(encoding);

	   HttpSession session = ((HttpServletRequest) request).getSession(false);
	   if(session!=null)
	   {
		   String keyReset=request.getParameter("reset");
		   if(keyReset!=null && keyReset.equals(Boolean.TRUE.toString()))
		   {
			   for(Enumeration e = session.getAttributeNames();e.hasMoreElements();)
			   {
				   String attName=(String) e.nextElement();
				   
				   if (attName != null && !EXEPTION_NETOYAGE.contains(attName))
				   {
					   session.removeAttribute(attName);
				   }
			   }
		   }
	   }
	   filterChain.doFilter(request, response);
	  }
	  public void destroy() {
	  }
	 }

