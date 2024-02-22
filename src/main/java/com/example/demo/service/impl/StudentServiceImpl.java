package com.example.demo.service.impl;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.dto.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    public Student insertByName(Student student){
        return studentDao.insertByName(student);
    }

    public void insertBatchByNames(List<Student> students){
        studentDao.insertBatchByNames(students);
    }

    public void deleteById(Integer id){
        studentDao.deleteById(id);
    }

    public List<Student> findAll(){
        return studentDao.findAll();
    }
    public Student findById(Integer id){
        return studentDao.findById(id);
    }
}
