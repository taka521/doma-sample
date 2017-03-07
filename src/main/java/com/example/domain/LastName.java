package com.example.domain;

import org.seasar.doma.Domain;

import java.io.Serializable;

/**
 * 姓クラス
 */
@Domain(valueType = String.class, factoryMethod = "of")
public class LastName implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String value;

    private LastName(final String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

    public static LastName of(final String value){
        return new LastName(value);
    }

}
