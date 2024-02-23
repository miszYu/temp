package com.example.demo.dao.impl;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.dto.Student;
import com.example.demo.model.mapper.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentDaoImpl implements StudentDao {
    //NamedParameterJdbcTemplate範例
    @Autowired
    @Qualifier("myjdbcJdbcTemplate")
    private NamedParameterJdbcTemplate myjdbcJdbcTemplate;

    public Student insertByName(Student student){
        String sql = "INSERT INTO STUDENT (name) VALUE (:name)";

        String name = student.getName();

        Map<String, Object> map = new HashMap<>();
        map.put("name", name);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        myjdbcJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        Integer id = keyHolder.getKey().intValue();

        student.setId(id);

        return student;
    }

    public void insertBatchByNames(List<Student> students){
        String sql = "INSERT INTO STUDENT (name) VALUE (:name)";

        List<MapSqlParameterSource> parameterSourceList = new ArrayList<>();
        MapSqlParameterSource parameterSource = null;

        for (Student std : students){
            parameterSource = new MapSqlParameterSource();
            parameterSource.addValue("name", std.getName());

            parameterSourceList.add(parameterSource);
        }
        MapSqlParameterSource[] parameterSources = parameterSourceList.toArray( new MapSqlParameterSource[parameterSourceList.size()]);
        myjdbcJdbcTemplate.batchUpdate(sql, parameterSources);
    }

    public void deleteById(Integer id){
        String sql = "DELETE FROM STUDENT WHERE ID = :id";

        Map<String, Object> map = new HashMap<>();
        map.put("id", id);

        myjdbcJdbcTemplate.update(sql, map);
    }
    public List<Student> findAll(){
        String sql = "SELECT id, name FROM STUDENT";

        Map<String,Object> map = new HashMap<>();

        List<Student> list =  myjdbcJdbcTemplate.query(sql, map, new StudentRowMapper());

        return list;
    }

    public Student findById(Integer id){
        String sql = "SELECT id, name FROM STUDENT where id = :id";

        Map<String,Object> map = new HashMap<>();
        map.put("id", id);

        List<Student> list =  myjdbcJdbcTemplate.query(sql, map, new StudentRowMapper());

        return list.size() > 0 ? list.get(0) : new Student(null, "查無資料");
    }
}
