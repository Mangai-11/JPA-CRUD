package com.example.JPA.Demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Student {
    @Id
    private int rno;
    private String name;
    private String gender;
    private String technology;



public Student(int rno,String name,String gender,String technology){
    this.rno=rno;
	this.name=name;
	this.gender=gender;
    this.technology=technology;
}
public Student(){

}
}
