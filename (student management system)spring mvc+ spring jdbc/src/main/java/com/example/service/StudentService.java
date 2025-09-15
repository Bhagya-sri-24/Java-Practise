package com.example.service;

import com.example.dao.StudentDao;
import com.example.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentDao dao;

    
    public StudentService(StudentDao dao) {
        this.dao = dao;
    }

    
    public List<Student> getAllStudents() {
        return dao.findAll();
    }

    
    public Optional<Student> getStudentById(int id) {
        return dao.findById(id);
    }

   
    public void addStudent(Student s) {
        validateForCreateOrUpdate(s, false);
        dao.save(s);
    }

  
    public void updateStudent(Student s) {
        if (s.getId() == null) {
            throw new IllegalArgumentException("ID is required for update");
        }
        validateForCreateOrUpdate(s, true);
        dao.update(s);
    }

    /** Delete */
    public void deleteStudent(int id) {
        dao.deleteById(id);
    }

 
    private void validateForCreateOrUpdate(Student s, boolean isUpdate) {
        if (s == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        if (s.getName() == null || s.getName().isBlank()) {
            throw new IllegalArgumentException("Name is required");
        }
        if (s.getEmail() == null || !s.getEmail().contains("@")) {
            throw new IllegalArgumentException("Valid email is required");
        }
        if (s.getCourse() == null || s.getCourse().isBlank()) {
            throw new IllegalArgumentException("Course is required");
        }
        
    }
}
