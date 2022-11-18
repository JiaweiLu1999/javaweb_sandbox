package com.javey.bookstore.servlet.model;

import com.javey.bookstore.bean.Book;
import com.javey.bookstore.service.impl.BookServiceImpl;
import com.javey.bookstore.servlet.base.ViewBaseServlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexServlet", value = "/index.html")
public class IndexServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookServiceImpl bookService = new BookServiceImpl();
        List<Book> allBook = bookService.findAllBook();
        request.setAttribute("books", allBook);
        processTemplate("index", request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
