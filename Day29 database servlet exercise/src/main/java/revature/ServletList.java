package revature;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletList extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
	 Employee employee = new Employee();
	 IEmployeeDAO employeeDao = new EmployeeDAOImpl();
	 PrintWriter out = response.getWriter();
	 
	 try {
		if (employeeDao.getEmployees().size() == 0) {
			 System.out.println("There are currently no pending accounts.");
		 } else {
			out.println("<h1>Employees:<h1>");
			
			for (Iterator<Employee> iter = employeeDao.getEmployees().iterator(); iter.hasNext();) {
				employee = iter.next();

//				out.println("Employee ID: " + employee.getId() + " | Name: " + employee.getName()
//				+ " | Email: " + employee.getEmail() + " | Gender: " + employee.getGender() 
//				+ " | Country: " + employee.getCountry() + "<a href=\"update.html\">Edit</a>" 
//				+ " | <a href=\"delete.html\">Delete</a>");
				
				out.println("<h2>Employee ID: " + employee.getId() + " | Name: " + employee.getName()
				+ " | Email: " + employee.getEmail() + " | Gender: " + employee.getGender() 
				+ " | Country: " + employee.getCountry() + "\n<a href=\"update.html\">Edit</a>" 
				+ " | <a href=\"delete.html\">Delete</a></h2>");
				out.println("*************************************");
			}
		 }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
