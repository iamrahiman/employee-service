package com.employee.search.filter;
/*
 * package com.apple.employee.search.filter;
 * 
 * import java.io.IOException; import java.util.Date;
 * 
 * import javax.servlet.Filter; import javax.servlet.FilterChain; import
 * javax.servlet.ServletException; import javax.servlet.ServletRequest; import
 * javax.servlet.ServletResponse; import javax.servlet.http.HttpServletRequest;
 * import javax.servlet.http.HttpServletResponse;
 * 
 * import org.springframework.stereotype.Component;
 * 
 *//**
	 * class to define filter to filter particular rest calls
	 * 
	 * @author abdul.rahimanshaik
	 *
	 */
/*
 * @Component public class EmployeeSearchFilter implements Filter {
 * 
 *//**
	 * 
	 * {@inheritDoc}
	 *//*
		 * @Override public void doFilter(ServletRequest request, ServletResponse
		 * response, FilterChain chain) throws IOException, ServletException {
		 * 
		 * HttpServletRequest httpRequest = (HttpServletRequest) request;
		 * HttpServletResponse httpResponse = (HttpServletResponse) response;
		 * System.out.println(httpRequest.getRequestURI()); if
		 * (httpRequest.getRequestURI().endsWith("/health")) {
		 * System.out.println("-------------"); try { Thread.sleep(10000); } catch
		 * (InterruptedException e) { e.printStackTrace(); }
		 * 
		 * if (httpRequest.getHeader("appID").equals("200") &&
		 * httpRequest.getHeader("CommonKey").equals("Conciese") && (new
		 * Date(System.currentTimeMillis()).getSeconds() - new
		 * Date(httpRequest.getHeader("Date")).getSeconds() <= 10)) {
		 * chain.doFilter(httpRequest, httpResponse); } else {
		 * httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
		 * System.out.println("Error"); } } else { chain.doFilter(httpRequest,
		 * httpResponse); }
		 * 
		 * }
		 * 
		 * }
		 */