package com.javey.bookstore.service.impl;


import com.javey.bookstore.bean.User;
import com.javey.bookstore.dao.UserDao;
import com.javey.bookstore.dao.impl.UserDaoImpl;
import com.javey.bookstore.service.UserService;
import com.javey.bookstore.util.MD5Util;

/**
 * @Author chenxin
 * @date 2022/3/8
 * @Version 1.0
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        //1. 先根据用户名查找User对象
        User userByUsername = userDao.findUserByUsername(username);
        //2. 如果找到，在验证密码是否正确(密码先加密后在验证)
        if (userByUsername != null) {
            String encode = MD5Util.encode(password);
            if (encode.equals(userByUsername.getPassword())) {
                return userByUsername;
            }
        }
        return null;
    }

    @Override
    public boolean regist(User user) {
        //1. 加密
        user.setPassword(MD5Util.encode(user.getPassword()));
        //2. 保存
        return userDao.addUser(user);
    }
}
