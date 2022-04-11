package com.controleservico.os.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthDate;

    @NotNull
    private String cpf;

    public People() {
    }

    public People(long id, String name, Date birthDate, String cpf) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.cpf = cpf;
    }

    public People(String name, Date birthDate, String cpf) {
        this.name = name;
        this.birthDate = birthDate;
        this.cpf = cpf;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
