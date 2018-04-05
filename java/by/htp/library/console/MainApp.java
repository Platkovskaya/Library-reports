package by.htp.library.console;

import by.htp.library.dao.BookDao;
import by.htp.library.dao.EmployeeDao;
import by.htp.library.dao.impl.BookDaoDBImpl;
import by.htp.library.dao.impl.EmployeeDaoDBImpl;
import by.htp.library.dao.util.ScannerUtils;

public class MainApp {

	public static void main(String[] args) {
		
		BookDao dao = new BookDaoDBImpl();
		dao.readAll();
		
		System.out.println();
		
		EmployeeDao empdao = new EmployeeDaoDBImpl();
		empdao.readAll();		
		
		System.out.println();
		
		BookDaoDBImpl bookDaoDBImpl = new BookDaoDBImpl();
		bookDaoDBImpl.read(ScannerUtils.inputString());;
		
		System.out.println();
		
		EmployeeDaoDBImpl employeeDaoDBImpl = new EmployeeDaoDBImpl();
		employeeDaoDBImpl.read(ScannerUtils.inputString());
		
		
		
		
		
			
		

	}

}
