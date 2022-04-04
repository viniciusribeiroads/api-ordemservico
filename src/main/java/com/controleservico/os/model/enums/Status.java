package com.controleservico.os.model.enums;

import com.controleservico.os.exception.NotFoundException;

public enum Status {

    ACCEPTED(1),
    CLOSE(2),
    REJECTED(3);

    private int statusCode;

    Status(int status) {
        this.statusCode = status;
    }

    public int getCode(){
        return statusCode;
    }

    public static Status getStatusByCode(int code){
        for (Status status : Status.values()){
            if (status.statusCode == code){
                return status;
            }

        }
        throw new NotFoundException("Codigo nao encontrado!");
    }
}
