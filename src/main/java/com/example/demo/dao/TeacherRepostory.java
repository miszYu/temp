package com.example.demo.dao;

import com.example.demo.model.dto.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//CrudRepository<Class, primary key type>
@Repository
public interface TeacherRepostory extends CrudRepository<Teacher, Integer> {

}
