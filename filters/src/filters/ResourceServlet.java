package filters;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResourceServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// login
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		
		// hardcoded login logic... call your DAO
		if(user.equals("dan") && pass.equals("pickles")) {
			//logged in.. 								new User()
			req.getSession().setAttribute("userInfo", new Object());
			System.out.println("Logged in!");
			resp.sendRedirect("/filters/index.html");
		}else {
			// not logged in
			resp.setStatus(401); // UNAUTHORIZED -- not authenticated 
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getRequestURI().contains("insecure")) {
			System.out.println("Accessed insecure resource");
		}else {
			System.out.println("Accessed secure resource");
		}
	}
}
