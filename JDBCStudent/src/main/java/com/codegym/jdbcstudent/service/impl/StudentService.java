package com.codegym.jdbcstudent.service.impl;

import com.codegym.jdbcstudent.model.Student;
import com.codegym.jdbcstudent.repository.IStudentRepository;
import com.codegym.jdbcstudent.repository.impl.StudentRepository;
import com.codegym.jdbcstudent.service.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
    IStudentRepository iStudentRepository = new StudentRepository();
    @Override
    public List<Student> findAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public void add(Student student) {
        iStudentRepository.add(student);
    }
}
