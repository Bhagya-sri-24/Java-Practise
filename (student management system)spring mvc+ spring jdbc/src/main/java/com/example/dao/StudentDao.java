package com.example.dao;

import com.example.model.Student;
import java.util.List;
import java.util.Optional;

public interface StudentDao {
    List<Student> findAll();
    Optional<Student> findById(int id);
    int save(Student s);
    int update(Student s);
    int deleteById(int id);
}
