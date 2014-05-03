package org.fit.pis.back;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;


public class UserAuthFilter implements Filter {
	 @SuppressWarnings("unused")
     private FilterConfig filterConfig = null;

	 public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	 {
	     HttpSession session = ((HttpServletRequest) request).getSession();
	     UserAuthBean auth = (UserAuthBean) session.getAttribute("userAuthBean");
	     if (auth != null && auth.isAuthorized())
	     {
	         chain.doFilter(request, response);
	     }
	     else
	     {
	         response.setContentType("text/html");
	         PrintWriter out = response.getWriter();
	         out.println("<html><head><title>Bad login</title></head><body>");
	         out.println("<h1>Access denied</h1>");
	         out.println("Access denied. <a href=\"../userlogin.xhtml\">Try again</a>.");
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
