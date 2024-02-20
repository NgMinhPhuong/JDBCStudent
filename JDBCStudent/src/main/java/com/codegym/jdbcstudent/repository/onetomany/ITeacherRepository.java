package com.codegym.jdbcstudent.repository.onetomany;

import com.codegym.jdbcstudent.model.onetomany.Teacher;

import java.util.List;

public interface ITeacherRepository {
    List<Teacher> findAll();
}
