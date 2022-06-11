package com.leitianyu.web;

import com.leitianyu.pojo.User;
import com.leitianyu.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String checkCode = request.getParameter("checkCode");
        HttpSession session = request.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");
        if (!checkCodeGen.equalsIgnoreCase(checkCode)){
            request.setAttribute("register_msg","验证码错误");
            request.getRequestDispatcher("register.jsp").forward(request,response);
            return;
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username,password);
        if (userService.selectByUsername(username)==null){
            userService.add(user);
            session.setAttribute("User",user);
            request.getRequestDispatcher("UserIndex.jsp").forward(request,response);
        }else {
            request.setAttribute("register_msg","用户已存在");
            request.getRequestDispatcher("register.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
