package com.codegym.jdbcstudent.repository.onetomany.impl;

import com.codegym.jdbcstudent.jdbc.manytoone.JDBCConnection;
import com.codegym.jdbcstudent.model.onetomany.Teacher;
import com.codegym.jdbcstudent.repository.onetomany.ITeacherRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepository implements ITeacherRepository {
    private static final String FIND_ALL = "select * from teacher";
    @Override
    public List<Teacher> findAll() {
        List<Teacher> lists = new ArrayList<>();
        try(Connection c = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(FIND_ALL)){
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Teacher teacher = new Teacher();
                teacher.setId(Integer.parseInt(rs.getString("id")));
                teacher.setName(rs.getString("name"));
                teacher.setSchool_id(Integer.parseInt(rs.getString("school_id")));
                lists.add(teacher);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lists;
    }
}
