package com.codegym.jdbcstudent.model.manytomany;

public class Class_Teacher {
    private int class_id;
    private int teacher_id;
    public Class_Teacher(){}

    public Class_Teacher(int student_id, int teacher_id) {
        this.class_id = student_id;
        this.teacher_id = teacher_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }
}
