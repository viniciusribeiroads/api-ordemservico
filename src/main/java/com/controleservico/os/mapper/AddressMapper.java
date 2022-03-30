package com.controleservico.os.mapper;

import com.controleservico.os.controller.dto.AddressDto;
import com.controleservico.os.controller.dto.PeopleDto;
import com.controleservico.os.model.AddressUser;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class AddressMapper {

    @Contract("_ -> new")
    public static @NotNull AddressUser toAddressEntity(@NotNull AddressDto addressDto){
        return new AddressUser(null,
                addressDto.getAddressType().getNumber(),
                addressDto.getNumber(),
                addressDto.getDistrict(),
                addressDto.getCity(),
                addressDto.getCep(),
                addressDto.getComplement(),
                PeopleMapper.toPeopleEntity(addressDto.getOwner()));
    }


    @Contract("_ -> new")
    public static @NotNull AddressDto toDto(@NotNull AddressUser addressUser){
        return new AddressDto(
                addressUser.getAddressType(),
                addressUser.getNumber(),
                addressUser.getDistrict(),
                addressUser.getCity(),
                addressUser.getCep(),
                addressUser.getComplement(),
                PeopleMapper.toDto(addressUser.getOwner()));
    }


}
