package com.javey.bookstore.service;

import com.javey.bookstore.bean.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBook();

    boolean addBook(Book book);

    boolean deleteBookById(String id);

    Book findBookById(String id);

    boolean editBook(Book book);
}
