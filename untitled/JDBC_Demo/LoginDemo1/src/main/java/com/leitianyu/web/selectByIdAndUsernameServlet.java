package com.leitianyu.web;

import com.leitianyu.pojo.User;
import com.leitianyu.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/selectByIdAndUsernameServlet")
public class selectByIdAndUsernameServlet extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String checkCode = request.getParameter("checkCode");
        HttpSession session = request.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");
        if (!checkCodeGen.equalsIgnoreCase(checkCode)){
            request.setAttribute("register_msg","验证码错误");
            request.getRequestDispatcher("find.jsp").forward(request,response);
            return;
        }
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        User user = new User(Integer.parseInt(id),username);
        User user1= userService.selectByIdAndUsername(user);
        if (user1==null){
            request.setAttribute("register_msg","用户不存在");
            request.getRequestDispatcher("find.jsp").forward(request,response);
        }else {
            session.setAttribute("User",user1);
            request.getRequestDispatcher("password.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
