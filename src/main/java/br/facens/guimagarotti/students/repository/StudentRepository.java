package br.facens.guimagarotti.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.facens.guimagarotti.students.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}