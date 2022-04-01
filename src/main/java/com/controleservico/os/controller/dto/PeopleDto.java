package com.controleservico.os.controller.dto;

import lombok.NoArgsConstructor;

import java.util.Date;
@NoArgsConstructor
public class PeopleDto {

    private String name;

    private Date birthDate;

    private String cpf;

    public PeopleDto(String name, Date birthDate, String cpf) {
        this.name = name;
        this.birthDate = birthDate;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getCpf() {
        return cpf;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
