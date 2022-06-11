package com.leitianyu.web;

import com.leitianyu.pojo.Brand;
import com.leitianyu.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/selectByIdServlet")
public class selectByIdServlet extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Brand brand = brandService.selectById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("brand",brand);
        request.getRequestDispatcher("update.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
