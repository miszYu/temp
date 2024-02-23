package com.example.demo.controller;

import com.example.demo.model.dto.Product;
import com.example.demo.model.dto.Student;

import com.example.demo.service.ProductService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//練習NamedParameterJdbcTemplate的使用

@Validated
@RestController
@RequestMapping("/jdbc")
public class JdbcController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ProductService productService;

    @PostMapping("/student")
    public String createStudent(@RequestBody Student student){
        Student stu = studentService.insertByName(student);

        Integer id = stu.getId();
        String name = stu.getName();

        return "已新增Student， id = " + id + ", name = " + name;
    }

    @PostMapping("/batch")
    public String createStudents(@RequestBody List<Student> students ){
        studentService.insertBatchByNames(students);

        return "已新增 batch insert ";
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable @Valid Integer id){
        studentService.deleteById(id);

        return "已刪除Student，id = " + id ;
    }

    @GetMapping("/students")
    public List<Student> selectStudent(){
        return studentService.findAll();
    }

    @GetMapping("/student/{id}")
    public Student selectStudent(@PathVariable @Valid Integer id){
        return studentService.findById(id);
    }

    @GetMapping("/product/{no}")
    public Product getProduct(@PathVariable @Valid Integer no){
        return productService.findByNo(no);
    }

}
