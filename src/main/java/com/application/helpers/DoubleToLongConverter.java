package com.application.helpers;

import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;

public class DoubleToLongConverter implements Converter<Double, Long> {

    @Override
    public Result<Long> convertToModel(Double fieldValue, ValueContext context) {
        if (fieldValue == null) {
            return Result.ok(null);
        }
        return Result.ok(fieldValue.longValue());
    }

    @Override
    public Double convertToPresentation(Long modelValue, ValueContext context) {
        if (modelValue == null) {
            return null; // ou 0.0 dependendo da sua lógica
        }
        return modelValue.doubleValue();
    }
}
