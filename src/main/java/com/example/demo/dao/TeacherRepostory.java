package com.example.demo.dao;

import com.example.demo.model.dto.Teacher;
import org.springframework.data.repository.CrudRepository;

//CrudRepository<Class, primary key type>
public interface TeacherRepostory extends CrudRepository<Teacher, Integer> {

}
