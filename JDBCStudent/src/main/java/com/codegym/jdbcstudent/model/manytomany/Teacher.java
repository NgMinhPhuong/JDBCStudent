package com.codegym.jdbcstudent.model.manytomany;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private int id;
    private String name;

    private List<Class> classes = new ArrayList<>();
    public Teacher(){}

    public Teacher(int id, String name, List<Class> classes) {
        this.id = id;
        this.name = name;
        this.classes = classes;
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

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }
}
