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

    @SuppressWarnings("null")
    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @SuppressWarnings("null")
    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @SuppressWarnings("null")
    @Override
    public void removeStudent(Long id) {
        Student student = getStudentById(id);
        if (student == null)
            throw new StudentNotFoundException("O Aluno com ID: " + id + " não foi encontrado.");

        studentRepository.deleteById(id);
    }
}
