package com.example.demo.service;

import com.example.demo.model.dto.Student;

import java.util.List;

public interface StudentService {

    Student insertByName(Student student);

    void insertBatchByNames(List<Student> students);

    void deleteById(Integer id);

    List<Student> findAll();

    Student findById(Integer id);
}
