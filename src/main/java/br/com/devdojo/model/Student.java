package br.com.devdojo.model;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity //Mapea a classe para uma Tabela Student
public class Student extends AbstractEntity{
    @NotEmpty(message = "Name is empty!")
    private String name;

    @NotEmpty(message = "Email is empty!")
    @Email
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
