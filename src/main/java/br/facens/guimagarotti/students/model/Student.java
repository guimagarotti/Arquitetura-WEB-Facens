package br.facens.guimagarotti.students.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do estudante não pode estar em branco.")
    @Size(min = 3, max = 50, message = "O nome do estudante deve ter entre 3 e 50 caracteres")
    private String name;

    @NotBlank(message = "O último nome do estudante não pode estar em branco.")
    @Size(min = 3, max = 50, message = "O último nome do estudante deve ter entre 3 e 50 caracteres")
    private String lastname;

    @NotBlank(message = "O endereço do estudante não pode estar em branco.")
    @Size(min = 3, max = 50, message = "O endereço do estudante deve ter entre 3 e 50 caracteres")
    private String address;

    @NotBlank(message = "O CPF do estudante não pode estar em branco.")
    @Size(min = 3, max = 50, message = "O CPF do estudante deve ter entre 3 e 50 caracteres")
    private String cpf;

    @NotBlank(message = "O hobby do estudante não pode estar em branco.")
    @Size(min = 3, max = 50, message = "O hobby do estudante deve ter entre 3 e 50 caracteres")
    private String hobby;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @NotNull
    private Course course;
}