package com.example.employee.controller;

import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeMvcController {

    private final EmployeeService service;

    public EmployeeMvcController(EmployeeService service) {
        this.service = service;
    }

 
    @GetMapping
    public String list(Model model) {
        model.addAttribute("employees", service.findAll());
        return "list";
    }

  
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("title", "Add Employee");
        return "form";
    }

    
    @PostMapping
    public String create(@Valid @ModelAttribute("employee") Employee e,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("title", "Add Employee");
            return "form";
        }
        service.create(e);
        return "redirect:/employees";
    }

   
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Employee e = service.findById(id);
        if (e == null) return "redirect:/employees";
        model.addAttribute("employee", e);
        model.addAttribute("title", "Edit Employee");
        return "form";
    }

 
    @PostMapping("/{id}")
    public String update(@PathVariable Long id,
                         @Valid @ModelAttribute("employee") Employee e,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("title", "Edit Employee");
            return "form";
        }
        if (service.update(id, e) == null) {
            return "redirect:/employees";
        }
        return "redirect:/employees";
    }

    
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/employees";
    }
}
