package com.example.JPA.Demo.repository;

import com.example.JPA.Demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
}
