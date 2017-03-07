package com.example.domain;

import org.seasar.doma.Domain;

import java.io.Serializable;

@Domain(valueType = String.class)
public class Name<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String value;

    public Name(final String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
