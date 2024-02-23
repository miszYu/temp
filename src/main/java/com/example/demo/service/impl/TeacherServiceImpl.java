package com.example.demo.service.impl;

import com.example.demo.dao.TeacherRepostory;
import com.example.demo.model.dto.Student;
import com.example.demo.model.dto.Teacher;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepostory teacherRepostory;

    @Override
    public Teacher insert(Teacher teacher){
        return teacherRepostory.save(teacher);
    }

}
