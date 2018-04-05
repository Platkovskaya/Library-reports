package by.htp.library.dao.impl;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmployeeTest {
	private EmployeeDaoDBImpl employeeDaoDBImpl;

	
	
	@BeforeMethod(alwaysRun = true)
	public void initTest() {
		employeeDaoDBImpl = new EmployeeDaoDBImpl();		
	}
	
	@Test
	public void PositiveFindEmployeeTest() {
		Assert.assertTrue(employeeDaoDBImpl.read("Ivanov"), "Employee was not found");
	}
	
	@Test
	public void NegativeFindEmployeeTest() {
		Assert.assertFalse(employeeDaoDBImpl.read("Vasechkin"), "Employee was found");
		
	}
	
}
	