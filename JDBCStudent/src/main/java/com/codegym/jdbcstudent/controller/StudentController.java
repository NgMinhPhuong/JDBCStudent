package com.codegym.jdbcstudent.controller;

import com.codegym.jdbcstudent.model.Student;
import com.codegym.jdbcstudent.service.IStudentService;
import com.codegym.jdbcstudent.service.impl.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/students")
public class StudentController extends HttpServlet {
    IStudentService iStudentService = new StudentService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null ) action = "";
        switch (action){
            case "add":
                showFormAdd(req,resp);
                break;
            default:
                showAll(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null ) action = "";
        switch (action){
            case "add":
                addStudent(req, resp);
        }
    }

    public void showFormAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/add.jsp");
        rd.forward(req,resp);
    }

    public void showAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/showall.jsp");
        req.setAttribute("students", iStudentService.findAll());
        rd.forward(req,resp);
    }

    public void addStudent(HttpServletRequest req, HttpServletResponse resq) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        Student student = new Student(id,name,email,address);
        iStudentService.add(student);
        resq.sendRedirect("/students");
    }
}
