package br.facens.guimagarotti.students.controller;

import org.springframework.web.bind.annotation.RestController;

import br.facens.guimagarotti.students.model.Student;
import br.facens.guimagarotti.students.service.StudentService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/findByName")
    public Student getStudentByName(@RequestParam String name) {
        return studentService.getStudentByName(name);
    }

    @DeleteMapping("/{id}")
    public Student removeStudentById(@PathVariable Long id) {
        return studentService.removeStudentById(id);
    }

    @PostMapping("/add")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }
}
