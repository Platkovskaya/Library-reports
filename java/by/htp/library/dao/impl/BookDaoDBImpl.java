package by.htp.library.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import by.htp.library.bean.Book;
import by.htp.library.dao.BookDao;
import by.htp.library.dao.util.DBConnectionHelper;

public class BookDaoDBImpl implements BookDao {
	private static final String SQL_SELECT_BOOKS = "select *from book";
	private static final String SQL_SELECT_BOOKSTITLE = "select title from book";

	public void create(Book entity) {

	}

	public Book read(int id) {
		return null;
	}

	public boolean read(String title) {
		boolean found = false;

		Connection connection = DBConnectionHelper.connect();
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_BOOKSTITLE);

			while (rs.next()) {
				if (rs.getString("title").equals(title)) {
					found = true;
					break;
				}
			}

			if (found) {
				System.out.println("Book '" + title + "' was found!");
			} else {
				System.out.println("Book '" + title + "' was not found!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBConnectionHelper.disconnect(connection);
		return found;
	}

	public List<Book> readAll() {
		List<Book> listBooks = new ArrayList<Book>();

		Connection connection = DBConnectionHelper.connect();
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_BOOKS);

			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("book_id"));
				book.setTitle(rs.getString("title"));
				book.setDescription(rs.getString("description"));
				book.setAuthor(rs.getString("author"));

				listBooks.add(book);
			}
			for (Book book : listBooks) {
				System.out.println(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBConnectionHelper.disconnect(connection);
		return listBooks;
	}

	public void delete(int id) {

	}

	public void update(Book entity) {

	}

}