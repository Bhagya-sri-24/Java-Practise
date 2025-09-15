package com.example.controller;

import com.example.model.Student;
import com.example.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    
    @GetMapping
    public String list(Model model) {
        model.addAttribute("students", service.getAllStudents());
        return "students"; // -> /WEB-INF/views/students.jsp
    }

    // ---------------- SHOW CREATE FORM ----------------
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("mode", "create");
        return "student-form"; // -> /WEB-INF/views/student-form.jsp
    }

   
    @PostMapping
    public String create(@RequestParam String name,
                         @RequestParam String email,
                         @RequestParam String course,
                         @RequestParam(required = false) String enrolledDate) {

        Student s = new Student();
        s.setName(name);
        s.setEmail(email);
        s.setCourse(course);

        if (enrolledDate != null && !enrolledDate.isBlank()) {
            s.setEnrolledDate(LocalDate.parse(enrolledDate));
        }

        service.addStudent(s);
        return "redirect:/students";
    }

    
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable int id, Model model) {
        Student s = service.getStudentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student id: " + id));
        model.addAttribute("student", s);
        model.addAttribute("mode", "edit");
        return "student-form"; // reuse the same form
    }

    
    @PostMapping("/{id}")
    public String update(@PathVariable int id,
                         @RequestParam String name,
                         @RequestParam String email,
                         @RequestParam String course,
                         @RequestParam(required = false) String enrolledDate) {

        Student s = new Student();
        s.setId(id);
        s.setName(name);
        s.setEmail(email);
        s.setCourse(course);

        if (enrolledDate != null && !enrolledDate.isBlank()) {
            s.setEnrolledDate(LocalDate.parse(enrolledDate));
        }

        service.updateStudent(s);
        return "redirect:/students";
    }

    
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable int id) {
        service.deleteStudent(id);
        return "redirect:/students";
    }
}
