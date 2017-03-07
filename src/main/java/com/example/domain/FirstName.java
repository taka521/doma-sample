package com.example.domain;

import org.seasar.doma.Domain;

import java.io.Serializable;

/**
 * 名クラス
 */
@Domain(valueType = String.class, factoryMethod = "of")
public class FirstName implements Serializable{

    private static final long serialVersionUID = 1L;
    private final String value;

    private FirstName(final String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

    public static FirstName of(final String value){
        return new FirstName(value);
    }
}
