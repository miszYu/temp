package com.example.demo.service;

import com.example.demo.model.dto.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TeacherService {

    Teacher insert(Teacher teacher);

    Teacher findById(Integer id);

    List<Teacher> findByName(String name);

    List<Teacher> findByGender_Stafflv(String gender, String stafflv);

}
