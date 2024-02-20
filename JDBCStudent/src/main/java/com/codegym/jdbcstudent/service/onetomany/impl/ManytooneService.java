package com.codegym.jdbcstudent.service.onetomany.impl;

import com.codegym.jdbcstudent.model.onetomany.School;
import com.codegym.jdbcstudent.model.onetomany.Teacher;
import com.codegym.jdbcstudent.repository.onetomany.ISchoolRepository;
import com.codegym.jdbcstudent.repository.onetomany.ITeacherRepository;
import com.codegym.jdbcstudent.repository.onetomany.impl.SchoolRepository;
import com.codegym.jdbcstudent.repository.onetomany.impl.TeacherRepository;
import com.codegym.jdbcstudent.service.onetomany.IManytooneService;

import java.util.List;

public class ManytooneService implements IManytooneService {
    private ISchoolRepository iSchoolRepository1_n = new SchoolRepository();
    private ITeacherRepository iTeacherRepository1_n = new TeacherRepository();

    @Override
    public List<School> findAll() {
        List<School> schoolList = iSchoolRepository1_n.findAll();
        List<Teacher> teacherList = iTeacherRepository1_n.findAll();
        schoolList.forEach(school -> {
            teacherList.forEach(teacher -> {
                if(teacher.getSchool_id() == school.getId()){
                    school.getTeacherList().add(teacher);
                }
            });
        });
        return schoolList;
    }
}
