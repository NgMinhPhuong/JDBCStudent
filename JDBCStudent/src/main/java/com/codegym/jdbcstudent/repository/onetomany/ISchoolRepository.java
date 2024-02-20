package com.codegym.jdbcstudent.repository.onetomany;

import com.codegym.jdbcstudent.model.onetomany.School;

import java.util.List;

public interface ISchoolRepository {
    List<School> findAll();

}
