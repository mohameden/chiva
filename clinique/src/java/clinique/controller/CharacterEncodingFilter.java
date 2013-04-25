package clinique.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class CharacterEncodingFilter implements Filter {

	  private FilterConfig filterConfig = null;

	  public void init(FilterConfig filterConfig) throws ServletException {
	      this.filterConfig = filterConfig;
	   }

	   public void destroy() {
	      this.filterConfig = null;
	   }

	   public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
	     request.setCharacterEncoding("utf-8");
	     response.setContentType("text/html;charset=utf-8");
	     chain.doFilter(request, response);
	   }



	}
