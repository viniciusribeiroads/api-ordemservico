package com.controleservico.os.model.enums;

import com.controleservico.os.exception.NotFoundException;

public enum AddressType {

    RESIDENCIAL(1),
    COMERCIAL(2),
    ENTREGA(3)
    ;

    private int numberType;


    AddressType(int numberType) {
        this.numberType = numberType;
    }

    public int getNumber(){
        return this.numberType;
    }

    public static AddressType getById(int id){
        for (AddressType address : AddressType.values()){
            if (address.getNumber() == id) {
                return address;
            }
        }
        throw new NotFoundException("Codigo nao encontrado!");
    }


}
