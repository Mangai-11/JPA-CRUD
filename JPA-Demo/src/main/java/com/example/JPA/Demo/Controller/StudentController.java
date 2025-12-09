package com.example.JPA.Demo.Controller;


import com.example.JPA.Demo.Service.StudentService;
import com.example.JPA.Demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
    
    @PostMapping("/students")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
         studentService.addStudent(student);
        return new ResponseEntity<>("Added...",HttpStatus.CREATED);
    }

    @GetMapping("/student/{rno}")
    public ResponseEntity<Student> getStudentbyrno(@PathVariable("rno") int rno){
      Student student= studentService.getStudentbyrno(rno);
      if(student==null){
          return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      else{
          return new ResponseEntity<>(student,HttpStatus.OK);
      }
    }

    @PutMapping("/students")
    public String updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return "updated";
    }

    @DeleteMapping("/students/{rno}")
    public String deleteStudent(@PathVariable("rno") int rno){
        studentService.deleteStudentbyrno(rno);
        return "deleted";
    }

    @DeleteMapping("/students/clear")
    public String deleteStudents(){
        studentService.clearstudent();
        return "deletedall";
    }

    @GetMapping("/students/{technology}")
    public List<Student> getStudentsByTech(@PathVariable("technology") String tech){
       return  studentService.getStudentsByTech(tech);
    }

    @PostMapping("/students/filter")
    public List<Student> filterStudents(@Param("gender") String gender,@Param("technology") String technology){
        return studentService.filterStudents(gender,technology);
    }


            }