package br.facens.guimagarotti.students.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
    @Id
    private Long id;
    private String name;
    private String lastName;
    private String address;
    private String cpf;
    private String hobby;

    public Student(Long id, String name, String lastName, String address, String cpf, String hobby) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.cpf = cpf;
        this.hobby = hobby;
    }

    public Student() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}