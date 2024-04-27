package br.facens.guimagarotti.students.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.facens.guimagarotti.students.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    /* Query Methods - Consultas Automáticas */
    List<Student> findByCourseId(Long courseId);
    List<Student> findByCourseName(String courseName);
    List<Student> findByCourseNameContaining(String parcialName);

    /* Query Methods - Consultas Customizadas */
    @Query("SELECT COUNT(s) from Student s WHERE s.course.id = :courseId")
    Long countStudentsByCourseId(@Param("courseId") Long courseId);

    @Query("SELECT COUNT(s) FROM Student s WHERE s.course.name LIKE %:parcialName%")
    Long countStudentsByParcialCourseName(@Param("parcialName") String parcialName);
}