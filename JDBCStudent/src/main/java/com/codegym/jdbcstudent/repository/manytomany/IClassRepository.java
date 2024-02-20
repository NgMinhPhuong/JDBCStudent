package com.codegym.jdbcstudent.repository.manytomany;

import com.codegym.jdbcstudent.model.manytomany.Class;

import java.util.List;

public interface IClassRepository {
    Class findAllById(int id);
    List<Class> findAll();
}
