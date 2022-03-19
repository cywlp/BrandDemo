package com.web; /**
 * @description :
 * @author :珠代
 * @create :2022-03-18 10:14:00
 */

import com.pojo.User;
import com.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //封装对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        //获取用户输入的验证码
        String checkCode = request.getParameter("checkCode");

        //获取程序生成的验证码，丛session中获得
        HttpSession session = request.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");
        //判断验证码是否正确
        if(!checkCodeGen.equalsIgnoreCase(checkCode)){
            //不允许注册
            request.setAttribute("register_msg", "验证码错误");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }
        //判断是否注册成功
        boolean flag = userService.register(user);

        if (flag) {
            //注册成功，跳转到登录页面
            request.setAttribute("register_msg", "注册成功，请登录");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            //注册失败，跳转到注册页面
            request.setAttribute("register_msg", "用户名已存在");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
