package com.codegym.jdbcstudent.repository.manytomany.impl;

import com.codegym.jdbcstudent.jdbc.manytomany.JDBCConnection;
import com.codegym.jdbcstudent.model.manytomany.Class;
import com.codegym.jdbcstudent.repository.manytomany.IClassRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassRepository implements IClassRepository {
    private static final String FIND_ALL_BY_ID = "select * from class where id = ?";
    private static final String FIND_ALL = "select * from class";

    @Override
    public Class findAllById(int id) {

        try(Connection c = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(FIND_ALL_BY_ID)){
            preparedStatement.setString(1, id+"");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Class cl = new Class();
                cl.setId(Integer.parseInt(rs.getString("id")));
                cl.setName(rs.getString("name"));
                return cl;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Class> findAll() {
        List<Class> lists = new ArrayList<>();
        try(Connection c = JDBCConnection.getConnection();
        PreparedStatement preparedStatement = c.prepareStatement(FIND_ALL)){
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Class cl = new Class();
                cl.setId(Integer.parseInt(rs.getString("id")));
                cl.setName(rs.getString("name"));
                lists.add(cl);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lists;
    }
}
