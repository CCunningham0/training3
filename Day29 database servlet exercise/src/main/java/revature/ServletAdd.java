package revature;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletAdd extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		 // Get user input
		 String name = request.getParameter("user_name");
		 String email = request.getParameter("user_email");
		 String gender = request.getParameter("user_gender");
		 String country = request.getParameter("user_country");

		 // Create new employee and set properties
		 Employee employee = new Employee();
		 IEmployeeDAO employeeDao = new EmployeeDAOImpl();
		 employee.setName(name);
		 employee.setEmail(email);
		 employee.setGender(gender);
		 employee.setCountry(country);
		 
		 try {
			employeeDao.addEmployee(employee);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 out.println("<h1>Added Employee!<h1>");
		 out.println("<h2><a href=\"index.html\">Back</a></h2>");
		 //out.println("<h1><a href='Servlet4?name="+ name+ "'>Click Here</a></h1>"); 
	}
}
