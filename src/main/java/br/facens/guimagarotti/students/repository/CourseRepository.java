package br.facens.guimagarotti.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.facens.guimagarotti.students.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
    
}
