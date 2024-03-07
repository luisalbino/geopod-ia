package com.application.models.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TokenResponseModel extends AbstractResponseModel {

    private String token;

    public TokenResponseModel(Integer status, String mensagem, String token) {
        super(status, mensagem);

        this.token = token;
    }
}
