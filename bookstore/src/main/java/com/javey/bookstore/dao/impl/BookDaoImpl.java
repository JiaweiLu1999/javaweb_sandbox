package com.javey.bookstore.dao.impl;

import com.javey.bookstore.bean.Book;
import com.javey.bookstore.dao.BaseDaoImpl;
import com.javey.bookstore.dao.BookDao;

import java.util.List;

public class BookDaoImpl extends BaseDaoImpl implements BookDao {
    String sql = " id bookId, title bookName, author, price, sales, stock, img_path imgPath ";

    @Override
    public List<Book> findAllBook() {
        String sql = "select " + this.sql + " from books";
        return this.getList(Book.class, sql);
    }

    @Override
    public boolean addBook(Book book) {
        String sql = "insert into books values(null,?,?,?,?,?,?)";
        return this.update(sql, book.getBookName(), book.getAuthor(), book.getPrice(),
                book.getSales(), book.getStock(), null) > 0;
    }

    @Override
    public boolean deleteBookById(String bookId) {
        String sql = "delete from books where id = ?";
        return this.update(sql, bookId) > 0;
    }

    @Override
    public Book findBookById(String id) {
        String sql = "select " + this.sql + " from books where id = ?";
        return this.getBean(Book.class, sql, id);
    }

    @Override
    public boolean editBook(Book book) {
        String sql = "update books set title=?, author=?, price=?, sales=?, stock=?, img_path=? where id = ?";
        return this.update(sql, book.getBookName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(),
                book.getImgPath(), book.getBookId()) > 0;
    }
}
