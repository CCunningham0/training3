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
		StringBuilder strBuild = new StringBuilder();
		strBuild.append(
				"<html>"
				+ "<head>"
				+ "<link href=\"bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\" />"		
				+ "<style>"
				+ "body {"
				+ "margin-left: 5%;"
				+ "margin-right: 5%;"
				+ "}"
				+ "</style>"
				+ "</head>"
				+ "<body >"
				+ "<script>"
				+ "var url = new URL(http://localhost:8080/database-servlet-exercise/list?);"
				+ "function addId(id) {"
				+ "url.searchParams.append('employee_id', id);"
				
				+ "</script>"
				+ "<table class=\"table table-dark\">"
				+ "<thead>"
				+ "<tr>"
				+ "<th scope=\"col\">ID</th>"
				+ "<th scope=\"col\">Name</th>"
				+ "<th scope=\"col\">Email</th>"
				+ "<th scope=\"col\">Gender</th>"
				+ "<th scope=\"col\">Country</th>"
				+ "<th scope=\"col\">Actions</th>"
				+ "</tr>"
				+ "</thead>"
				+ "<tbody>");

		try {
			if (employeeDao.getEmployees().size() == 0) {
				System.out.println("There are currently no employees.");
			} else {
				out.println("<h1>Employees:<h1>");

				for (Iterator<Employee> iter = employeeDao.getEmployees().iterator(); iter.hasNext();) {
					employee = iter.next();

					strBuild.append("<tr><td>")
					.append(employee.getId())
					.append("</td><td>")
					.append(employee.getName())
					.append("</td><td>")
					.append(employee.getEmail())
					.append("</td><td>")
					.append(employee.getGender())
					.append("</td><td>")
					.append(employee.getCountry())
					.append("</td><td>")
					.append("<form action=\"update\" method=\"post\">"
							+ "<input type=\"submit\" value=\"edit\" name=\"edit\" onclick=\"addId("+ employee.getId()+");\">"
							+ "<input type=\"submit\" value=\"delete\" name=\"delete\" onclick=\"addId("+ employee.getId()+");\">")

					.append("</td></tr>");

					//				out.println("<form action='update' method='post'>
					//						<td><input type="submit" value="edit" name="edit"  onclick="update(<%=s %>);"> </td>
					//						</form>
					//	            ");				
				}
				
				strBuild.append(
						"</tbody>"
						+ "</table>"
						+ "</body>"
						+ "</html>");
				out.println(strBuild.toString());
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
