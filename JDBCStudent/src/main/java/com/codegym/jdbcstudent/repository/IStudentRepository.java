package com.codegym.jdbcstudent.repository;

import com.codegym.jdbcstudent.model.Student;

import java.util.List;

public interface IStudentRepository {
    Student findById(int id);
    List<Student> findAll();
    void add(Student student);
}
