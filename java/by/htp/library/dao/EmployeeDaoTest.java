package by.htp.library.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.library.bean.Employee;
import by.htp.library.dao.impl.EmployeeDaoDBImpl;
import by.htp.library.dao.util.DBConnectionHelper;

public class EmployeeDaoTest {
	private Connection connection;
	private List<Employee> expectedList;
	private EmployeeDao dao;

	@BeforeClass
	public void initDefaultDBConnection() {
		connection = DBConnectionHelper.connect();

		System.out.println("Before class: connection opened");
	}

	@BeforeMethod
	public void getExpectedList() throws SQLException {
		System.out.println("Before method");

		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("select * from employee");

		expectedList = new ArrayList<>();

		while (rs.next()) {
			expectedList.add(new Employee());
		}
		System.out.println("BeforeMethod: actualList was recieved");

	}

	@BeforeMethod
	public void initDao() {
		dao = new EmployeeDaoDBImpl();
	}

	@Test
	public void testRecievedCorrectEmployeeCount() {
		List<Employee> actualList = dao.readAll();
		Assert.assertEquals(actualList.size(), expectedList.size(), "The received count of books is not correct");
	}

	@AfterClass
	public void closeDBConnection() {
		DBConnectionHelper.disconnect(connection);
		System.out.println("AfterClass: connection closed");
	}

	@AfterMethod
	public void cleanExpectedValues() {
		expectedList = null;
		System.out.println("After method");
	}

}
