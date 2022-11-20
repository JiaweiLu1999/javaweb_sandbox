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
        String code = request.getParameter("code");
        Object key = request.getSession().getAttribute("KAPTCHA_SESSION_KEY");

        //1. 获得请求参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (code != null && code.equals(key)) {
            //2. 处理注册的业务(暂时不考虑用户名重复的问题)
            //将信息添加到数据库即可(密码的加密问题)
            UserService userService = new UserServiceImpl();
            boolean b = userService.regist(user);
            //3. 给响应(页面跳转)
            if (b) {
                request.setAttribute("username", user.getUsername());
                processTemplate("user/regist_success", request, response);
            }
        } else {
            request.setAttribute("user", user);
            request.setAttribute("code", code);
            request.setAttribute("codeErrMsg", "Error Code!");
            processTemplate("user/regist", request, response);
        }


    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserService userService = new UserServiceImpl();
        User login = userService.login(username, password);

        if (login == null) {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("errMsg", "Wrong Username/Password!");
            processTemplate("user/login", request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", login);
            processTemplate("user/login_success", request, response);
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath() + "/index.html");
    }


}
