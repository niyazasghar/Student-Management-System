package com.managementSystem.controller;

import com.managementSystem.entity.Student;
import com.managementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/get")
    public String getAllStudent(Model themodel){
    themodel.addAttribute("students",studentService.getAllStudents());
    return "list-students";
    }

    @GetMapping("/new")
    public String createStudentForm(Model themodel) {

        // create student object to hold student form data
        Student student = new Student();
        themodel.addAttribute("student", student);
        return "create-student-form";

    }
    @PostMapping("/saveStudent")
    public  String saveStudents(@ModelAttribute("student") Student thestudent){
        studentService.saveStudent(thestudent);
        return "redirect:/students/get";
    }
    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id , Model themodel){
        Student tempStudent= studentService.getStudentById(id);
        themodel.addAttribute("student",tempStudent);
        return "update-student-form";
    }
    @PostMapping("/saveUpdate/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student theEditedstudent){
        //get Student from database
        Student existingStudent=studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(theEditedstudent.getFirstName());
        existingStudent.setLastName(theEditedstudent.getLastName());
        existingStudent.setEmail(theEditedstudent.getEmail());
        studentService.updateStudent(existingStudent);
        return "redirect:/students/get";
    }
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        Student existingStudent=studentService.getStudentById(id);
        studentService.deleteStudentById(id);
        return "redirect:/students/get";
    }

}
