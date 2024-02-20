package com.codegym.jdbcstudent.model.onetomany;

public class Teacher {
    private int id;
    private String name;

    private int school_id;
    public Teacher(){}

    public Teacher(int id, String name, int school_id) {
        this.id = id;
        this.name = name;
        this.school_id = school_id;
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

    public int getSchool_id() {
        return school_id;
    }

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }
}
