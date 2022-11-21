package com.example.ajax.servlet;

import com.example.ajax.bean.User;
import com.example.ajax.util.CommonResult;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class AjaxTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("This is ajax test 02 servlet");
        User admin = new User(0, "admin", "123123", "jl5999@gmail.com");
        CommonResult res = CommonResult.ok().setResultData(admin).setMessage("Add a user named admin");
        Gson gson = new Gson();
        String s = gson.toJson(res);
        PrintWriter writer = response.getWriter();
        writer.write(s);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
