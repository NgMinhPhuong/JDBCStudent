package com.codegym.jdbcstudent.repository.impl;

import com.codegym.jdbcstudent.jdbc.JDBCConnection;
import com.codegym.jdbcstudent.model.Student;
import com.codegym.jdbcstudent.repository.IStudentRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static final String FIND_BY_ID = "select * from student where id = ?";
    private static final String FIND_ALL = "select * from student";
    private static final String ADD_STUDENT = "insert into student values(?,?,?,?)";
    public Student findById(int id){
        try(Connection c = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(FIND_BY_ID)){
            preparedStatement.setString(1, id + "");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int id1 = Integer.parseInt(rs.getString("id"));
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                return new Student(id1,name, email, address);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Student> findAll(){
        List<Student> students = new ArrayList<>();
        try(Connection c = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(FIND_ALL)){
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int id1 = Integer.parseInt(rs.getString("id"));
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                students.add(new Student(id1,name,email,address));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public void add(Student student){
        try(Connection c = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(ADD_STUDENT)){
            preparedStatement.setString(1, student.getId() + "");
            preparedStatement.setString(2,student.getName());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getAddress());
            if(preparedStatement.executeUpdate() == 0){
                System.out.println("không thêm được ");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
