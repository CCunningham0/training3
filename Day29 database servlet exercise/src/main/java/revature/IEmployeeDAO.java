package revature;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeDAO {
	void addEmployee(Employee employee) throws SQLException;
	void updateEmployee(Employee employee) throws SQLException;
	void deleteEmployee(Employee employee) throws SQLException;
	List<Employee> getEmployees() throws SQLException;
}