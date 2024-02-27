package com.example.demo.dao;

import com.example.demo.model.dto.Teacher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//CrudRepository<Class, primary key type>
@Repository
public interface TeacherRepostory extends CrudRepository<Teacher, Integer> {

    List<Teacher> findByName(String name);

    //nativeQuery，使用哪種語法，true = 一般SQL、false = JPQL
    @Query(value = "SELECT ID, NAME, GENDER, STAFFLV FROM TEACHER WHERE GENDER=?1 AND STAFFLV=?2", nativeQuery = true)
    List<Teacher> findByGender_Stafflv(String gender, String stafflv);
}
