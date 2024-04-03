package br.facens.guimagarotti.students.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.facens.guimagarotti.students.model.Student;
import br.facens.guimagarotti.students.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student getStudentByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
}
