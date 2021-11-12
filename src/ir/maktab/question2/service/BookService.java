package ir.maktab.question2.service;

import ir.maktab.question2.dao.BookDao;
import ir.maktab.question2.model.Book;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookService {
    private final BookDao bookDao;

    public BookService() throws SQLException, ClassNotFoundException {
        bookDao = new BookDao();
    }

    public Map<String, List<Book>> getListBook() throws SQLException {
        return bookDao.allBook().stream().collect(Collectors.groupingBy(i -> i.getAuthorName()));

    }
}
