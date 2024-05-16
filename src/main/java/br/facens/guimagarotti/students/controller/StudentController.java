package br.facens.guimagarotti.students.controller;

import org.springframework.web.bind.annotation.RestController;

import br.facens.guimagarotti.students.exceptions.StudentNotFoundException;
import br.facens.guimagarotti.students.model.Student;
import br.facens.guimagarotti.students.service.StudentService;
import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @PostMapping("/add")
    public ResponseEntity<?> createStudent(@Valid @RequestBody Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }

        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeStudent(@PathVariable Long id) {
        try {
            studentService.removeStudent(id);
            return ResponseEntity.ok("Item deletado com sucesso!");
        } catch (StudentNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/byCourseId/{id}")
    public List<Student> getStudentsByCourseId(@PathVariable Long id) {
        return studentService.getStudentsByCourseId(id);
    }

    @GetMapping("/byCourseName/{name}")
    public List<Student> getStudentsByCourseName(@PathVariable String name) {
        return studentService.getStudentsByCourseName(name);
    }

    @GetMapping("/byCourseNameContaining/{partialName}")
    public List<Student> getStudentsByCourseNameContaining(@PathVariable String partialName) {
        return studentService.getStudentsByCourseNameContaining(partialName);
    }

    @GetMapping("/countByCourseId/{courseId}")
    public Long countStudentsByCourseId(@PathVariable Long courseId) {
        return studentService.countStudentsByCourseId(courseId);
    }

    @GetMapping("/countByPartialCourseName/{partialName}")
    public Long countStudentsByPartialCourseName(@PathVariable String partialName) {
        return studentService.countStudentsByPartialCourseName(partialName);
    }
}