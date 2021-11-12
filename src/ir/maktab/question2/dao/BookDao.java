package ir.maktab.question2.dao;


import ir.maktab.question2.model.Book;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    private Connection connection = null;

    public BookDao() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/maktab58",
                "root", "SAMAseven@7");
    }

    public java.sql.Connection getConnection() {
        return connection;
    }

    public void setConnection(java.sql.Connection connection) {
        this.connection = connection;
    }

    public List<Book> allBook() throws SQLException {

        if (connection != null) {

            String sqlQuery = String.format("select * from book_store");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            List<Book> books = new ArrayList<>();
            while (resultSet.next()) {
                books.add(bookCreat(resultSet));
            }
            return books;
        }
        return null;
    }

    public Book bookCreat(ResultSet resultSet) throws SQLException {

        Book book = new Book();
        book.setAuthorName(resultSet.getString(2));
        book.setIsbn(resultSet.getInt(3));
        book.setTitle(resultSet.getString(4));
        book.setPublishYear(resultSet.getInt(5));
        book.setPrice(resultSet.getInt(6));
        book.setSoldNumber(resultSet.getInt(7));

        return book;
    }

}