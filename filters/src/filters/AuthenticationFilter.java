package filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * for /secure/* requests,
 * make sure userInfo session obj isn't null
 * 
 * @author PWalsh
 *
 */
public class AuthenticationFilter implements javax.servlet.Filter{

	@Override
	public void destroy() {
		System.out.println("Filter destory");
	}

	@Override
	public void doFilter(ServletRequest request, 
			ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Filtering..");
		// what happens when a request matches the filter's pattern
		// intercept that request here
		HttpServletRequest req = (HttpServletRequest) request;
		if(req.getSession().getAttribute("userInfo") == null) {
			// not logged in
			((HttpServletResponse) response).setStatus(401);
		}else {
			// logged in
			chain.doFilter(req, response); // MUST call this
			// forwarding req,resp to the next in the chain
			// could be another filter, or the servlet that was requested
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter init");
	}

}
