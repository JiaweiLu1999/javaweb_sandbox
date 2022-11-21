package com.example.ajax.servlet;



import com.example.ajax.bean.User;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ArrayList<User> arrayList = new ArrayList<>();
        arrayList.add(new User(0, username, password, null));
        arrayList.add(new User(1, username, password, ""));


        Gson gson = new Gson();
        String s = gson.toJson(arrayList);

        PrintWriter writer = response.getWriter();
        writer.write(s);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
