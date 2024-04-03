package br.facens.guimagarotti.students.service;

import java.util.List;

import br.facens.guimagarotti.students.model.Student;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student getStudentByName(String name);
    Student createStudent(Student student); 
}
