package com.application.models.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractResponseModel implements Serializable {

    private Integer status;
    private String mensagem;
}
