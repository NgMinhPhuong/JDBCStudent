package com.codegym.jdbcstudent.controller.manytomany;

import com.codegym.jdbcstudent.model.manytomany.Class;
import com.codegym.jdbcstudent.service.manytomany.ImanytomanyService;
import com.codegym.jdbcstudent.service.manytomany.impl.ManytomanyService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/manytomany")
public class ManytoManyController extends HttpServlet {
    private ImanytomanyService imanytomanyService = new ManytomanyService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) action = "";
        switch (action){
            case "hg":
                break;
            default:
               showAll(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    public void showAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Class> lists = imanytomanyService.findAll();
        req.setAttribute("lists", lists);
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/manytomany/showall.jsp");
        rd.forward(req,resp);
    }
}
