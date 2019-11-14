package com.skillstorm.training;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Build a "Trainee" API
 * 
 * @author PWalsh
 *
 */
public class TraineeServlet extends HttpServlet {

	private HashMap<Integer, Trainee> fakeDatabase = new HashMap<Integer, Trainee>();

	// init (1 time when app is initialized)
	// service (for each HTTP request)
	// destroy (1 time when when the app is undeployed)
	@Override
	public void init() throws ServletException {
		System.out.println("INIT");
		fakeDatabase.put(1, new Trainee(1, "Dan Pickles", "IT"));
		fakeDatabase.put(2, new Trainee(2, "Howard Johnson", "CS"));
		fakeDatabase.put(3, new Trainee(3, "Randolph Scott", "IT"));
	}

	@Override
	public void destroy() {
		System.out.println("DESTROY");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get the HTTP request Body
		ServletInputStream stream = req.getInputStream();

		ObjectMapper mapper = new ObjectMapper();
		// read the ServletInputStream and convert to type: Trainee
		Trainee trainee = mapper.readValue(stream, Trainee.class);
		fakeDatabase.put(trainee.getId(), trainee);
		// new TraineeDAO().save(trainee);
		System.out.println("Saved new trainee: " + trainee);
	}

	/**
	 * URL form-encoded
			k=v&k2=v2&source=hp&q=your+query
	 */
	//      http://localhost:8080/training/trainee?id=1
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		String param = req.getParameter("id"); // pass params to servlets
		// usually use params 
		if (param != null) {
			resp.getWriter().print(new ObjectMapper()
					.writeValueAsString(fakeDatabase.get(Integer.parseInt(param))));
		} else {
			// object mapper will read Java object state and convert it to JSON
			ObjectMapper mapper = new ObjectMapper();

			// HINT: you might actually call the DAO for your data here?
			// TraineeDAO dao = new TraineeDAO();
			// resp.getWriter().print(mapper.writeValueAsString(dao.findAll()));

			String json = mapper.writeValueAsString(fakeDatabase.values());
			System.out.println(json); // console SERVER-SIDE

			// JavaScript Object Notation
			// { "id" : 1, "name" : "Dan Pickles", "major" : "IT" }
			resp.getWriter().print(json); // write that JSON to the HTTP response
		}
	}

}
