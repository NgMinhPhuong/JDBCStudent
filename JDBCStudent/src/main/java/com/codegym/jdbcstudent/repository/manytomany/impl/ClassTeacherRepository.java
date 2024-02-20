package com.codegym.jdbcstudent.repository.manytomany.impl;

import com.codegym.jdbcstudent.jdbc.manytomany.JDBCConnection;
import com.codegym.jdbcstudent.model.manytomany.Class_Teacher;
import com.codegym.jdbcstudent.repository.manytomany.IClassTeacherRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassTeacherRepository implements IClassTeacherRepository {
    private static final String FIND_ALL = "select * from class_teacher";
    @Override
    public List<Class_Teacher> findAll() {
        List<Class_Teacher> lists = new ArrayList<>();
        try(Connection c = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(FIND_ALL);){
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Class_Teacher classTeacher = new Class_Teacher();
                classTeacher.setClass_id(Integer.parseInt(rs.getString("class_id")));
                classTeacher.setTeacher_id(Integer.parseInt(rs.getString("teacher_id")));
                lists.add(classTeacher);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lists;
    }
}
