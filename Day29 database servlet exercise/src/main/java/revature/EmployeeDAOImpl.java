package revature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements IEmployeeDAO {
	private static Statement statement = null;
	private static PreparedStatement preparedStatement = null;
	Connection conn = null;
	
	public EmployeeDAOImpl() {
		System.out.println("Calling ConnectionFactory, conn is: " + this.conn);
		this.conn = ConnectionFactory.getConnection();
		System.out.println("conn is now: " + this.conn);
	}

	@Override
	public void addEmployee(Employee employee) throws SQLException {
		String sql = "insert into employees (Name, Email, Gender, Country) values (?, ?, ?, ?)";
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, employee.getName());
		preparedStatement.setString(2, employee.getEmail());
		preparedStatement.setString(3, employee.getGender());
		preparedStatement.setString(4, employee.getCountry());	
		int count = preparedStatement.executeUpdate();
		
		if (count > 0) // if getting 0, issue has occurred
			System.out.println("Added employee!");
		else
			System.out.println("Sorry, an issue as occured.");
	}

	@Override
	public void updateEmployee(Employee employee) throws SQLException {
		String sql = "update employees where id = " + employee.getId();
		preparedStatement = conn.prepareStatement(sql);
		int count = preparedStatement.executeUpdate();
		
		if (count > 0) // if getting 0, issue has occurred
			System.out.println("Removed pending account!");
		else
			System.out.println("Sorry, an issue as occured.");
	}

	@Override
	public void deleteEmployee(Employee employee) throws SQLException {
		String sql = "delete from employees where id = " + employee.getId();
		preparedStatement = conn.prepareStatement(sql);
		int count = preparedStatement.executeUpdate();
		
		if (count > 0) // if getting 0, issue has occurred
			System.out.println("Deleted employee!");
		else
			System.out.println("Sorry, an issue as occured.");
	}

	@Override
	public List<Employee> getEmployees() throws SQLException {
		String sql = "select * from employees";
		statement = conn.createStatement();
		List<Employee> employees = new ArrayList<Employee>();
		ResultSet resultSet = statement.executeQuery(sql);
		Employee employee;
		
		while (resultSet.next()) {
			employee = new Employee(resultSet.getInt(1), resultSet.getString(2), 
					resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
			employees.add(employee);
		}
		
		return employees;
	}
}
