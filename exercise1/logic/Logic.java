package by.jonline.grow.end.exercise1.logic;

import by.jonline.grow.end.exercise1.bean.Book;
import by.jonline.grow.end.exercise1.bean.User;
import by.jonline.grow.end.exercise1.dao.BookDao;
import by.jonline.grow.end.exercise1.dao.UserDao;
import by.jonline.grow.end.exercise1.exception.DataNotFoundException;

import java.io.IOException;
import java.util.List;

public class Logic {

    public void signUp(String login, String password) throws IOException {
        UserDao userDao = new UserDao();
        userDao.saveRecord(new User(login, password));
    }

    public void signIn(String login, String password) throws IOException, DataNotFoundException {

        UserDao userDao = new UserDao();
        User user = (User) userDao.getRecord(login);
        if (user.getPassword().equals(password)) {
            return;
        } else {
            throw new DataNotFoundException("неверный пароль");
        }

    }

    public Book searchBook(String name) throws IOException, DataNotFoundException {

        BookDao bookDao = new BookDao();
        Book book;

        book = (Book) bookDao.getRecord(name);

        return book;

    }

    public List<Object> getBooks(int start, int end) throws IOException {
        BookDao bookDao = new BookDao();
        List<Object> records;

        records = bookDao.getRecords(start,end);

        return records;

    }

}
