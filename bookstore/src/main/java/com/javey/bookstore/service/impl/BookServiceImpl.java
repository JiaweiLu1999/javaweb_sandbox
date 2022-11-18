package com.javey.bookstore.service.impl;

import com.javey.bookstore.bean.Book;
import com.javey.bookstore.dao.BookDao;
import com.javey.bookstore.dao.impl.BookDaoImpl;
import com.javey.bookstore.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public List<Book> findAllBook() {
        return bookDao.findAllBook();
    }

    @Override
    public boolean addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public boolean deleteBookById(String id) {
        return bookDao.deleteBookById(id);
    }

    @Override
    public Book findBookById(String id) {
        return bookDao.findBookById(id);
    }

    @Override
    public boolean editBook(Book book) {
        return bookDao.editBook(book);
    }
}
