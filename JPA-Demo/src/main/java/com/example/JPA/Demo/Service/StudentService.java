package com.example.JPA.Demo.Service;

import com.example.JPA.Demo.model.Student;
import com.example.JPA.Demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;
    public List<Student> getStudents() {

        return studentRepo.findAll();
    }

    public void addStudent(Student student) {
         studentRepo.save(student);
    }

    public Student getStudentbyrno(int rno) {
        return studentRepo.findById(rno) .orElse(null);
    }

    public void updateStudent(Student student) {
        studentRepo.save(student);
    }

    public void deleteStudentbyrno(int rno) {
        studentRepo.deleteById(rno);
    }

    public void clearstudent() {
        studentRepo.deleteAll();
    }

    public List<Student> getStudentsByTech(String tech) {
       return studentRepo.findByTechnology(tech);
    }

    public List<Student> filterStudents(String gender, String technology) {
        return studentRepo.findByGenderAndTechnology(gender,technology);
    }
}
