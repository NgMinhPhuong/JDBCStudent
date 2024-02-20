package com.codegym.jdbcstudent.repository.manytomany.impl;

import com.codegym.jdbcstudent.jdbc.manytomany.JDBCConnection;
import com.codegym.jdbcstudent.model.manytomany.Teacher;
import com.codegym.jdbcstudent.repository.manytomany.ITeacherRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepositorty implements ITeacherRepository {

    private static final String FIND_BY_ID = "select * from teacher where id = ?";
    @Override
    public Teacher findAllById(int id) {

        try(Connection c = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(FIND_BY_ID)){
            preparedStatement.setString(1, id+"");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Teacher teacher = new Teacher();
                teacher.setId(Integer.parseInt(rs.getString("id")));
                teacher.setName(rs.getString("name"));
                return teacher;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
