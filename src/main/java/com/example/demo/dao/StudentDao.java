package com.example.demo.dao;

import com.example.demo.model.dto.Student;

import java.util.List;

public interface StudentDao {

    Student insertByName(Student student);

    void insertBatchByNames(List<Student> students);

    void deleteById(Integer id);

    List<Student> findAll();

    Student findById(Integer id);
}
