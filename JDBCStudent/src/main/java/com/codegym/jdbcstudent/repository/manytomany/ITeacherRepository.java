package com.codegym.jdbcstudent.repository.manytomany;

import com.codegym.jdbcstudent.model.manytomany.Teacher;

import java.util.List;

public interface ITeacherRepository {
    Teacher findAllById(int id);
}
