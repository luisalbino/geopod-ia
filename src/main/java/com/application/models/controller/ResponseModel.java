package com.application.models.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
public class ResponseModel<T> extends AbstractResponseModel {

    private Collection<T> data;

    public ResponseModel(Integer status, String mensagem, Collection<T> data) {
        super(status, mensagem);
        this.data = data;
    }
}
