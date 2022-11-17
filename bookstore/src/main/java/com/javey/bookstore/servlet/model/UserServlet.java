package com.javey.bookstore.servlet.model;

import com.javey.bookstore.bean.User;
import com.javey.bookstore.service.UserService;
import com.javey.bookstore.service.impl.UserServiceImpl;
import com.javey.bookstore.servlet.base.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends BaseServlet {

    protected void toRegisterPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processTemplate("user/regist", request, response);
    }

    protected void toLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processTemplate("user/login", request, response);
    }

    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获得请求参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //2. 处理注册的业务(暂时不考虑用户名重复的问题)
        //将信息添加到数据库即可(密码的加密问题)
        UserService userService = new UserServiceImpl();
        boolean b = userService.regist(user);
        //3. 给响应(页面跳转)
        if (b) {
            request.setAttribute("username", user.getUsername());
            processTemplate("user/regist_success", request, response);
        } else {
            processTemplate("user/regist", request, response);
        }
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1. 获得参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //2. 调用业务层进行业务处理
        UserService userService = new UserServiceImpl();
        User login = userService.login(username, password);
        //3. 给响应
        if (login == null) {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("errMsg", "Wrong Username/Password!");
            processTemplate("user/login", request, response);
        } else {
            request.setAttribute("user", login);
            processTemplate("user/login_success", request, response);
        }
    }


}
