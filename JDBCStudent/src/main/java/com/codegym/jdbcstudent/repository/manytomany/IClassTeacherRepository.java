package com.codegym.jdbcstudent.repository.manytomany;

import com.codegym.jdbcstudent.model.manytomany.Class_Teacher;

import java.util.List;

public interface IClassTeacherRepository {
    List<Class_Teacher> findAll();
}
