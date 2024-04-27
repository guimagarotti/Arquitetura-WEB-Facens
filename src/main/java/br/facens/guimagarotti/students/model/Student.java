package br.facens.guimagarotti.students.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private Long id;
    private String name;
    private String lastname;
    private String address;
    private String cpf;
    private String hobby;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}