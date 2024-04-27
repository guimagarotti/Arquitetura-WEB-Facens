package br.facens.guimagarotti.students.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.facens.guimagarotti.students.exceptions.StudentNotFoundException;
import br.facens.guimagarotti.students.model.Student;
import br.facens.guimagarotti.students.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void removeStudent(Long id) {
        Student student = getStudentById(id);
        if (student == null)
            throw new StudentNotFoundException("O Aluno com ID: " + id + " não foi encontrado.");

        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudentsByCourseId(Long courseId) {
        return studentRepository.findByCourseId(courseId);
    }

    @Override
    public List<Student> getStudentsByCourseName(String courseName) {
        return studentRepository.findByCourseName(courseName);
    }

    @Override
    public List<Student> getStudentsByCourseNameContaining(String parcialName) {
        return studentRepository.findByCourseNameContaining(parcialName);
    }

    @Override
    public Long countStudentsByCourseId(Long courseId) {
        return studentRepository.countStudentsByCourseId(courseId);
    }

    @Override
    public Long countStudentsByPartialCourseName(String partialName) {
        return studentRepository.countStudentsByParcialCourseName(partialName);
    }
}
