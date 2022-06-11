package com.leitianyu.web;

import com.leitianyu.pojo.User;
import com.leitianyu.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/selectByIdServlet")
public class selectByIdServlet extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String checkCode = request.getParameter("checkCode");
        HttpSession session = request.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");
        if (!checkCodeGen.equalsIgnoreCase(checkCode)){
            request.setAttribute("register_msg","验证码错误");
            request.getRequestDispatcher("findName.jsp").forward(request,response);
            return;
        }
        String id = request.getParameter("id");
        User user = new User(Integer.parseInt(id));
        User user1 = userService.selectById(user);
        if (user1!=null){
            session.setAttribute("User",user1);
            request.getRequestDispatcher("username.jsp").forward(request,response);
        }else {
            request.setAttribute("register_msg","用户不存在");
            request.getRequestDispatcher("findName.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doGet(request,response);
    }
}
