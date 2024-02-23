package com.example.demo.model.dto;


import javax.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id//primary key，需增加@Id的Annotation
    @GeneratedValue(strategy = GenerationType.IDENTITY)//AUTO_INCREMENT(自動增長)，需增加@GeneratedValue的Annotation
    @Column(name = "id")
    Integer id;

    @Column(name = "name")
    String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
