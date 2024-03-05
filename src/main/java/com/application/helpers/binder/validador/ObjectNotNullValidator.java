package com.application.helpers.binder.validador;

import com.vaadin.flow.data.binder.ValidationResult;
import com.vaadin.flow.data.binder.Validator;
import com.vaadin.flow.data.binder.ValueContext;

import java.util.Objects;

public class ObjectNotNullValidator implements Validator<Object> {

    @Override
    public ValidationResult apply(Object object, ValueContext valueContext) {
        if (Objects.isNull(object)) {
            return ValidationResult.error("Informe um valor válido!");
        }

        return ValidationResult.ok();
    }
}
