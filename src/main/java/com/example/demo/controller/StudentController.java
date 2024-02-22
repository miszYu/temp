package com.example.demo.controller;

import com.example.demo.model.dto.Store;
import com.example.demo.model.dto.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

//restFUL API，綜合範例。使用POST、GET、PUT、DELETE對應Create、Read、Update、Delete操作，用ResponseEntity設定httpCode並回傳數值。
//使用@Validated、@Valid，搭配model中的@NotNull、@NotBlank、@NotEmpty進行快速驗證

@RestController
@Validated
@RequestMapping("/student")
public class StudentController {

    @RequestMapping(path="/store", method = {RequestMethod.GET, RequestMethod.POST})
    public Store product(){
        //http://localhost:8080/test/store
        Store store = new Store();
        List<String> product = new ArrayList<>();
        product.add("蘋果");
        product.add("橘子");

        store.setProductList(product);

        return store;
    }
    @RequestMapping(path = "/user", method = {RequestMethod.GET, RequestMethod.POST})
    public Student user(){
        //http://localhost:8080/test/user
        Student student = new Student();
        student.setName("Judy");

        return student;
    }


    @PostMapping(path = "/add")
    public ResponseEntity<String> create(@RequestBody @Valid Student student){
        System.out.println("student.getId() = " + student.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body("執行資料庫的 Create 操作");
    }

    @GetMapping("/{studentId}")
    public Student read(@PathVariable @Min(10) Integer studentId){
        return new Student(studentId, "testName");
    }

    @PutMapping("/{studentId}")
    public String update(@PathVariable Integer studentId, @RequestBody Student student){
        student.print();
        return "執行資料庫的 Update 操作, Student " + student.toString();
    }

    @DeleteMapping("/{studentId}")
    public String delete(@PathVariable Integer studentId){
        return "執行資料庫的 Delete 操作, Student Id = " + studentId;
    }
}
