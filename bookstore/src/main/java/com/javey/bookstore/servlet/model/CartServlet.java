package com.javey.bookstore.servlet.model;

import com.google.gson.Gson;
import com.javey.bookstore.bean.Book;
import com.javey.bookstore.bean.Cart;
import com.javey.bookstore.bean.CartItem;
import com.javey.bookstore.service.BookService;
import com.javey.bookstore.service.impl.BookServiceImpl;
import com.javey.bookstore.servlet.base.BaseServlet;
import com.javey.bookstore.util.CommonResult;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CartServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        Book bookById = bookService.findBookById(id);
        cart.addCart(bookById);
        CommonResult res = CommonResult.ok().setResultData(cart.getTotalCount());
        response.getWriter().write(new Gson().toJson(res));
    }

    protected void toCartPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.processTemplate("cart/cart", request, response);
    }

    protected void showCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        Collection<CartItem> allCartItem = cart.getAllCartItem();
        Integer totalCount = cart.getTotalCount();
        Double totalAmount = cart.getTotalAmount();
        List<Object> list = new ArrayList<>();
        list.add(allCartItem);
        list.add(totalCount);
        list.add(totalAmount);
        CommonResult commonResult = CommonResult.ok().setResultData(list);
        String s = new Gson().toJson(commonResult);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(s);
    }


}
