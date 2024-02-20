package com.codegym.jdbcstudent.model.manytomany;

import java.util.ArrayList;
import java.util.List;

public class Class {
    private int id;
    private String name;
    private List<Teacher> teachers = new ArrayList<>();

    public Class(){}

    public Class(int id, String name, List<Teacher> teachers) {
        this.id = id;
        this.name = name;
        this.teachers = teachers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
