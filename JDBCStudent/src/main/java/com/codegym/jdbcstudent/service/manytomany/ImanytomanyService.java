package com.codegym.jdbcstudent.service.manytomany;

import com.codegym.jdbcstudent.model.manytomany.Class;

import java.util.List;

public interface ImanytomanyService {
    List<Class> findAll();
}
