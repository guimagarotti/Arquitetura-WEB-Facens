package br.facens.guimagarotti.students.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.facens.guimagarotti.students.model.Student;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private final List<Student> students = new ArrayList<>();
    private Long nextId = 1L;

    public StudentRepositoryImpl() {
        // Adiciona algumas tarefas pré-cadastradas
        students.add(new Student(1L, "Guilherme", "Rodrigues", "Carlos Miguel, 35", "45714459083", "Futebol"));
        students.add(new Student(1L, "Lívia", "Alves", "Carlos Antônio, 457", "55689098312", "Ballet"));
        students.add(new Student(1L, "Gabriel", "Pereira", "Jonas Antonieta, 123", "33145672133", "Filme"));
        nextId = 4L; // Atualiza o próximo ID
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public Student findById(Long id) {
        return students.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Student save(Student student) {
        if (student.getId() == null) {
            student.setId(nextId++);
            students.add(student);
        } else {
            students.removeIf(t -> t.getId().equals(student.getId()));
            students.add(student);
        }
        return student;
    }
}
