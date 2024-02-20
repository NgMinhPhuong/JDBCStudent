package com.codegym.jdbcstudent.controller.onetomany;

import com.codegym.jdbcstudent.model.onetomany.School;
import com.codegym.jdbcstudent.service.onetomany.IManytooneService;
import com.codegym.jdbcstudent.service.onetomany.impl.ManytooneService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/onetomany")
public class OneToManyController extends HttpServlet {
    private IManytooneService iManytooneService = new ManytooneService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) action = "";
        switch (action){
            case "ds":
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
        List<School> lists = iManytooneService.findAll();
        req.setAttribute("lists", lists);
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/onetomany/showall.jsp");
        rd.forward(req, resp);
    }
}
