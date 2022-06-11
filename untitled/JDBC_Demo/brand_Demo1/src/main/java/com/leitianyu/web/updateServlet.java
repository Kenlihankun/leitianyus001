package com.leitianyu.web;

import com.leitianyu.pojo.Brand;
import com.leitianyu.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Brand brand = new Brand(Integer.parseInt(request.getParameter("id")),request.getParameter("brandName"),request.getParameter("companyName"),Integer.parseInt(request.getParameter("ordered")),request.getParameter("description"),Integer.parseInt(request.getParameter("status")));
        brandService.update(brand);
        request.getRequestDispatcher("selectAllServlet").forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
