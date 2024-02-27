package com.example.demo.service.impl;

import com.example.demo.dao.TeacherRepostory;
import com.example.demo.model.dto.Student;
import com.example.demo.model.dto.Teacher;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepostory teacherRepostory;

    @Override
    public Teacher insert(Teacher teacher){
        return teacherRepostory.save(teacher);
    }

    @Override
    public Teacher findById(Integer id){
        return teacherRepostory.findById(id).orElse(null);
    }

    @Override
    public List<Teacher> findByName(String name){
        return teacherRepostory.findByName(name);
    }

    @Override
    public List<Teacher> findByGender_Stafflv(String gender, String stafflv){
        return teacherRepostory.findByGender_Stafflv(gender, stafflv);
    }
}
