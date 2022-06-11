package com.leitianyu.web;

import com.leitianyu.pojo.User;
import com.leitianyu.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user =  new User(request.getParameter("username"), request.getParameter("password"));
        User select = userService.select(user);
        if (select!=null){
            HttpSession session = request.getSession();
            session.setAttribute("User",select);
            if ("1".equals(request.getParameter("remember"))){
                response.addCookie(new Cookie("username",select.getUsername()));
                response.addCookie(new Cookie("password",select.getPassword()));
            }
            request.getRequestDispatcher("UserIndex.jsp").forward(request,response);
        }else {
            request.setAttribute("login_msg","账户或密码不正确");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
