package br.facens.guimagarotti.students.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private List<String> students = new ArrayList<>();

    public StudentController() {
        students.add("Aluno 1 - Guilherme");
        students.add("Aluno 2 - Jonas");
        students.add("Aluno 3 - Lívia");
    }

    @GetMapping
    public List<String> getAllStudents() {
        return students;
    }

    @GetMapping("/{student}")
    public String getStudentById(@PathVariable int student) {
        if (student >= 0 && student < students.size()) {
            return students.get(student);
        } else {
            return "Aluno não encontrado!";
        }
    }

    @PostMapping("/add")
    public void createStudent(@RequestBody String student) {
        students.add(student);
        System.out.println("Aluno adicionado: " + student);
    }
}