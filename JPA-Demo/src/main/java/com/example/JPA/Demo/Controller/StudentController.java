package com.example.JPA.Demo.Controller;


import com.example.JPA.Demo.Service.StudentService;
import com.example.JPA.Demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String addStudent(@RequestBody Student student){
         studentService.addStudent(student);
        return "added";
    }

    @GetMapping("/student/{rno}")
    public Student getStudentbyrno(@PathVariable("rno") int rno){
        return studentService.getStudentbyrno(rno);
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

}
