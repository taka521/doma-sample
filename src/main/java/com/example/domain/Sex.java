package com.example.domain;

import org.seasar.doma.Domain;

import java.io.Serializable;

/**
 * 性別列挙体
 */
@Domain(valueType = String.class, factoryMethod = "of")
public enum Sex implements Serializable {
    MALE("0"),
    FEMALE("1");

    private static final long serialVersionUID = 1L;
    private final String value;

    private Sex(final String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

    public static Sex of(String value){
        for(Sex sex : Sex.values()){
            if(sex.getValue().equals(value)){
                return sex;
            }
        }

        throw new IllegalArgumentException(value);
    }
}
