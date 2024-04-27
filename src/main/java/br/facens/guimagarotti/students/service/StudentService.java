package br.facens.guimagarotti.students.service;

import java.util.List;

import br.facens.guimagarotti.students.model.Student;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student createStudent(Student student); 
    void removeStudent(Long id);

    List<Student> getStudentsByCourseId(Long courseId);
    List<Student> getStudentsByCourseName(String courseName);
    List<Student> getStudentsByCourseNameContaining(String parcialName);

    Long countStudentsByCourseId(Long courseId);

    Long countStudentsByPartialCourseName(String partialName);
}
