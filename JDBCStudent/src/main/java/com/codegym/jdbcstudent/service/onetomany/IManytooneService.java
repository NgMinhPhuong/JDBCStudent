package com.codegym.jdbcstudent.service.onetomany;

import com.codegym.jdbcstudent.model.onetomany.School;

import java.util.List;

public interface IManytooneService {
    List<School> findAll();
}
