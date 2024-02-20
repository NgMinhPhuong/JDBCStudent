package com.codegym.jdbcstudent.repository.onetomany.impl;

import com.codegym.jdbcstudent.jdbc.manytoone.JDBCConnection;
import com.codegym.jdbcstudent.model.onetomany.School;
import com.codegym.jdbcstudent.repository.onetomany.ISchoolRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SchoolRepository implements ISchoolRepository {
    private static final String FIND_ALL = "select * from school";
    @Override
    public List<School> findAll() {
        List<School> lists = new ArrayList<>();
        try(Connection c = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(FIND_ALL)){
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                School school = new School();
                school.setId(Integer.parseInt(rs.getString("id")));
                school.setName(rs.getString("name"));
                lists.add(school);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lists;
    }
}
