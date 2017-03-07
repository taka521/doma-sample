package com.example.domain;

import org.seasar.doma.Domain;

import java.io.Serializable;

/**
 * パスワードクラス
 */
@Domain(valueType = String.class, factoryMethod = "of")
public class Password implements Serializable{

    private static final long serialVersionUID = 1L;
    private final String value;

    private Password(final String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

    public static Password of(final String value){
        return new Password(value);
    }
}
