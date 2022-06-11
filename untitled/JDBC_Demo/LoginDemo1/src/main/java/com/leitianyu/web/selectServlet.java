package com.leitianyu.web;

import com.leitianyu.pojo.User;
import com.leitianyu.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/selectServlet")
public class selectServlet extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user =  new User(request.getParameter("username"), request.getParameter("password"));
        User select = userService.selectByUsername(user.getUsername());
        if (select!=null){
            request.setAttribute("register_msg","已有账户");
            request.getRequestDispatcher("register.jsp").forward(request,response);

        }else {
            request.setAttribute("user",user);
            request.getRequestDispatcher("AddServlet").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
