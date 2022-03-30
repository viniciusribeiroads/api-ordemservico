package com.controleservico.os.mapper;

import com.controleservico.os.controller.dto.PeopleDto;
import com.controleservico.os.model.People;

public class PeopleMapper {

    public static PeopleDto toDto(People people){
        return new PeopleDto(
                people.getName(),
                people.getBirthDate(),
                people.getCpf());
    }

    public static People toPeopleEntity(PeopleDto peopleDto){
        return new People(
                peopleDto.getName(),
                peopleDto.getBirthDate(),
                peopleDto.getCpf());
        }
    }

