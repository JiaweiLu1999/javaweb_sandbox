package com.javey.servlet_demo;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Hello Servlet methods....");
        System.out.println(request.getServletContext().getAttribute("msg"));
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter( );
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");

        request.getRequestDispatcher("login");
    }

    public void destroy() {
    }
}