package revature;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletUpdate extends HttpServlet {
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
		 
		List<Employee> employees = null;
		try {
			employees = employeeDao.getEmployees();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		Employee listEmployee = new Employee();
		for (Iterator<Employee> iter = employees.iterator(); iter.hasNext();) {
				listEmployee = iter.next();
				if (employee.getName().equals(listEmployee.getName()) && 
						employee.getEmail().equals(listEmployee.getEmail())){
					 try {
							employeeDao.updateEmployee(listEmployee);
							out.println("<h1>Updated Employee!<h1>");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 break;
				}
		}
		 

		 
		 out.println("<h2><a href=\"index.html\">Back</a></h2>");
	}
}
