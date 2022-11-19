package com.javey.bookstore.servlet.model;

import com.javey.bookstore.bean.Book;
import com.javey.bookstore.service.BookService;
import com.javey.bookstore.service.impl.BookServiceImpl;
import com.javey.bookstore.servlet.base.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "BookServlet", value = "/book")
public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void findAllBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Book> allBook = bookService.findAllBook();
        request.setAttribute("books", allBook);
        processTemplate("manager/book_manager", request, response);
    }

    protected void toAddBookPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processTemplate("manager/book_add", request, response);
    }

    protected void addBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String[]> map = request.getParameterMap();
        Book book = new Book();
        try {
            BeanUtils.populate(book, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        boolean b = bookService.addBook(book);

        if (b) {
            response.sendRedirect(request.getContextPath() + "/book?flag=findAllBook");
        }
    }

    protected void deleteBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String bookId = request.getParameter("id");
        boolean b = bookService.deleteBookById(bookId);

        if (b) {
            response.sendRedirect(request.getContextPath() + "/book?flag=findAllBook");
        } else {
            System.out.println("delete error");
        }

    }

    protected void toEditBookPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        Book book = bookService.findBookById(id);
        request.setAttribute("book", book);
        this.processTemplate("manager/book_edit", request, response);
    }

    protected void editBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Book book = new Book();
        try {
            BeanUtils.populate(book, parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        boolean b = bookService.editBook(book);
        if (b) {
            response.sendRedirect(request.getContextPath() + "/book?flag=findAllBook");
        }

    }

    }
