package br.facens.guimagarotti.students.repository;

import java.util.List;

import br.facens.guimagarotti.students.model.Student;

public interface StudentRepository {
    List<Student> findAll();
    Student findById(Long id);
    Student save(Student student);
}