package com.controleservico.os.controller.dto;

import java.util.Date;

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
}
