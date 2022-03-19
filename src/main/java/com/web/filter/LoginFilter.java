package com.web.filter; /**
 * @description :登录验证的过滤器
 * @author :珠代
 * @create :2022-03-18 20:12:00
 */

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        //判断资源是否和登录注册有关
        String[] urls = {"/login.jsp", "/imgs/", "/css/", "/loginServlet", "/register.jsp", "/registerServlet", "/checkCodeServlet"};
        //获取当前访问路径
        String url = req.getRequestURL().toString();
        for (String u : urls) {
            if (url.contains(u)) {
                //放行
                chain.doFilter(request, response);
                return;
            }

        }
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");

        if (user != null) {
            //验证通过
            //放行
            chain.doFilter(request, response);
        } else {
            //验证失败，存储提示信息，跳转到登录页面

            req.setAttribute("login_msg", "您尚未登录！");
            req.getRequestDispatcher("/login.jsp").forward(req, response);

        }

    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

}
