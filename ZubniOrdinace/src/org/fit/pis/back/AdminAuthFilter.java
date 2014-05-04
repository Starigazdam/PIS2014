package org.fit.pis.back;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;


public class AdminAuthFilter implements Filter {
	 @SuppressWarnings("unused")
     private FilterConfig filterConfig = null;

	 public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	 {
	     HttpSession session = ((HttpServletRequest) request).getSession();
	     AdminAuthBean auth = (AdminAuthBean) session.getAttribute("adminAuthBean");
	     if(!session.isNew()) {
	    	 if (auth != null && auth.isAuthorized())
		     {
		         chain.doFilter(request, response);
		     }
		     else
		     {
		         response.setContentType("text/html");
		         PrintWriter out = response.getWriter();
		         out.println("<html><head><meta http-equiv=\"refresh\" content=\"2; url=../admlogin.xhtml\" />");
		         out.println("<title>Bad login.</title></head><body>");
		         out.println("<h1>Access denied</h1>");
		         out.println("Access denied. Redirecting back to <a href=\"../admlogin.xhtml\">Login</a>.");
		         out.println("</body></html>");
		     }
	     }
	     else {
	    	 response.setContentType("text/html");
	         PrintWriter out = response.getWriter();
	         out.println("<html><head><meta http-equiv=\"refresh\" content=\"2; url=../admlogin.xhtml\" />");
	         out.println("<title>Access denied.</title></head><body>");
	         out.println("<h1>You are not logged in.</h1>");
	         out.println("Redirecting you to <a href=\"../admlogin.xhtml\">Login.</a>.");
	         out.println("</body></html>");
	     }
	 }
	
	 public void destroy() 
	 {
	 }
	
	 public void init(FilterConfig filterConfig) 
	 {
	     this.filterConfig = filterConfig;
	 }


}
