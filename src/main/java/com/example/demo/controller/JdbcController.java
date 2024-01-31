package com.example.demo.controller;

import com.example.demo.model.clazz.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang3.StringUtils;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

//NamedParameterJdbcTemplate範例

@Validated
@RestController
@RequestMapping("/jdbc")
public class JdbcController {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student){
        String sql = "INSERT INTO STUDENT (name) VALUE (:name)";

        String name = student.getName();

        Map<String, Object> map = new HashMap<>();
        map.put("name", name);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        Integer id = keyHolder.getKey().intValue();

        return "已新增Student， id = " + id + ", name = " + name;
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable @Valid Integer id){
        String sql = "DELETE FROM STUDENT WHERE ID = :id";

        Map<String, Object> map = new HashMap<>();
        map.put("id", id);

        jdbcTemplate.update(sql, map);

        return "已刪除Student，id = " + id ;
    }
}
