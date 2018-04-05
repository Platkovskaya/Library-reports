package by.htp.library.dao.impl;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookTest {
	
private BookDaoDBImpl bookDaoDBImpl;

	
	
	@BeforeMethod(alwaysRun = true)
	public void initTest() {
		bookDaoDBImpl = new BookDaoDBImpl();		
	}
	
	@Test
	public void PositiveFindBookTest() {
		Assert.assertTrue(bookDaoDBImpl.read("The Great Gatsby"), "Book was not found");
	}
	
	@Test
	public void NegativeFindBookTest() {
		Assert.assertFalse(bookDaoDBImpl.read("Master and Margarita"), "Employee was found");
		
	}
	

}
