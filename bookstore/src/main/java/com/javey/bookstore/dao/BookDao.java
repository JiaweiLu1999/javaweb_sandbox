package com.javey.bookstore.dao;

import com.javey.bookstore.bean.Book;

import java.util.List;

public interface BookDao {
    List<Book> findAllBook();

    boolean addBook(Book book);

    boolean deleteBookById(String id);

    Book findBookById(String id);

    boolean editBook(Book book);
}
