package com.application.helpers.interfaces;

@FunctionalInterface
public interface RunnableWithParameter<P> {

    void run(P parametro);

}
