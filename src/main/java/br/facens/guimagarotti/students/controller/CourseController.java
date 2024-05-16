package br.facens.guimagarotti.students.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.facens.guimagarotti.students.model.Course;
import br.facens.guimagarotti.students.repository.CourseRepository;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course != null)
            return ResponseEntity.ok(course);
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/add")
    public ResponseEntity<?> createCourse(@Valid @RequestBody Course course, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }

        Course createdCourse = courseRepository.save(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCourse);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeCourse(@PathVariable Long id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            return ResponseEntity.ok("Curso removido com sucesso!");
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado.");
    }
}
