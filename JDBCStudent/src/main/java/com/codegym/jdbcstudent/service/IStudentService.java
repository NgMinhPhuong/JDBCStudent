package com.codegym.jdbcstudent.service;

import com.codegym.jdbcstudent.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void add(Student student);
}
