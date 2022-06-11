package com.leitianyu.web;

import com.leitianyu.pojo.Brand;
import com.leitianyu.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Brand brand = new Brand(request.getParameter("brandName"),request.getParameter("companyName"),Integer.parseInt(request.getParameter("ordered")),request.getParameter("description"),Integer.parseInt(request.getParameter("status")));
        brandService.add(brand);
        request.getRequestDispatcher("selectAllServlet").forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
