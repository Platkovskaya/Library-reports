package by.htp.library.dao;

import by.htp.library.bean.Book;

public interface BookDao extends BaseDao<Book>{
	
	public boolean read(String surname); 
}
