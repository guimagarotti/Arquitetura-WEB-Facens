package br.facens.guimagarotti.students.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.facens.guimagarotti.students.model.Student;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private final JdbcTemplate jdbcTemplate;

    public StudentRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> findAll() {
        return jdbcTemplate.query("SELECT * FROM student", (resultSet, rowNum) -> {
            System.out.println("Numero da linha: " + rowNum);
            return new Student(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getString("lastName"),
                    resultSet.getString("address"),
                    resultSet.getString("cpf"),
                    resultSet.getString("hobby"));
        });
    }

    @SuppressWarnings("deprecation")
    public Student findById(Long id) {
        String query = "SELECT * FROM student WHERE id = ?;";

        return jdbcTemplate.queryForObject(query, new Object[] { id }, (resultSet, rowNum) -> new Student(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("lastName"),
                resultSet.getString("address"),
                resultSet.getString("cpf"),
                resultSet.getString("hobby")));
    }

    @SuppressWarnings("deprecation")
    public Student findByName(String name) {
        String query = "SELECT * FROM student WHERE name = ?;";

        return jdbcTemplate.queryForObject(query, new Object[] { name }, (resultSet, rowNum) -> new Student(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("lastName"),
                resultSet.getString("address"),
                resultSet.getString("cpf"),
                resultSet.getString("hobby")));
    }

    public Student save(Student student) {
        if (student.getId() != null) {
            String insertQuery = "INSERT INTO public.student (id, name, lastName, address, cpf, hobby) VALUES (?, ?, ?, ?, ?, ?)";

            jdbcTemplate.update(insertQuery, student.getId(), student.getName(), student.getLastName(),
                    student.getAddress(), student.getCpf(), student.getHobby());
        } else {
            String updateQuery = "UPDATE public.student SET name = ?, lastName = ?, address = ?, cpf = ?, hobby = ? WHERE id = ?";
            jdbcTemplate.update(updateQuery, student.getName(), student.getLastName(), student.getAddress(),
                    student.getCpf(), student.getHobby());
        }

        return student;
    }
}
