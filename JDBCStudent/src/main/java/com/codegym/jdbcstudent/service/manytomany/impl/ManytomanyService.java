package com.codegym.jdbcstudent.service.manytomany.impl;

import com.codegym.jdbcstudent.model.manytomany.Class;
import com.codegym.jdbcstudent.model.manytomany.Class_Teacher;
import com.codegym.jdbcstudent.model.manytomany.Teacher;
import com.codegym.jdbcstudent.repository.manytomany.IClassRepository;
import com.codegym.jdbcstudent.repository.manytomany.IClassTeacherRepository;
import com.codegym.jdbcstudent.repository.manytomany.ITeacherRepository;
import com.codegym.jdbcstudent.repository.manytomany.impl.ClassRepository;
import com.codegym.jdbcstudent.repository.manytomany.impl.ClassTeacherRepository;
import com.codegym.jdbcstudent.repository.manytomany.impl.TeacherRepositorty;
import com.codegym.jdbcstudent.service.manytomany.ImanytomanyService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ManytomanyService implements ImanytomanyService {
    private ITeacherRepository iTeacherRepositoryn_n = new TeacherRepositorty();
    private IClassRepository iClassRepositoryn_n = new ClassRepository();
    private IClassTeacherRepository iClassTeacherRepositoryn_n = new ClassTeacherRepository();

    @Override
    public List<Class> findAll() {
        List<Class_Teacher> classTeachers = new ArrayList<>();
        classTeachers = iClassTeacherRepositoryn_n.findAll();
        List<Class> classes = iClassRepositoryn_n.findAll();
        classTeachers.forEach(line -> {
            Teacher teacher;
            teacher = iTeacherRepositoryn_n.findAllById(line.getTeacher_id());
            classes.forEach(line1 -> {
                if(line1.getId() == line.getClass_id()){
                    line1.getTeachers().add(teacher);
                }
            });
        });
        return classes;
    }


}
