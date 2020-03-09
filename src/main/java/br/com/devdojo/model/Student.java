package br.com.devdojo.model;

import javax.persistence.Entity;

@Entity //Mapea a classe para uma Tabela Student
public class Student extends AbstractEntity{
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
