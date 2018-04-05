package by.htp.library.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import by.htp.library.bean.Employee;
import by.htp.library.dao.EmployeeDao;
import by.htp.library.dao.util.DBConnectionHelper;

public class EmployeeDaoDBImpl implements EmployeeDao {
	private static final String SQL_SELECT_EMPLOYEE = "select *from employee";
	private static final String SQL_SELECT_BOOKSTITLE = "select surname from employee";

	public void create(Employee entity) {

	}

	public Employee read(int id, String name, String surname) {
		return null;
	}

	public boolean read(String surname) {
		boolean found = false;

		Connection connection = DBConnectionHelper.connect();
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_BOOKSTITLE);

			while (rs.next()) {
				if (rs.getString("surname").equals(surname)) {
					found = true;
					break;
				}

			}

			if (found) {
				System.out.println("Surname '" + surname + "' was found!");
			} else {
				System.out.println("Surname '" + surname + "' was not found!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBConnectionHelper.disconnect(connection);

		return found;
	}

	public List<Employee> readAll() {
		List<Employee> listEmployee = new ArrayList<Employee>();

		Connection connection = DBConnectionHelper.connect();
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_EMPLOYEE);

			while (rs.next()) {
				Employee emp = new Employee();
				emp.setName(rs.getString("name"));
				emp.setSurname(rs.getString("surname"));

				listEmployee.add(emp);
			}
			for (Employee employee : listEmployee) {
				System.out.println(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBConnectionHelper.disconnect(connection);
		return listEmployee;
	}

	public void delete(String name, String surname) {

	}

	public void update(Employee entity) {

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Employee read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}