package com.example.domain;

import org.seasar.doma.Domain;

import java.io.Serializable;
import java.util.Optional;

/**
 * メールアドレスクラス
 */
@Domain(valueType = String.class, factoryMethod = "of")
public class MailAddress implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String value;

    private MailAddress(final String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

    public static MailAddress of(final String value){
        return new MailAddress(value);
    }

    public Optional<MailAddress> toOptional(){
        return Optional.ofNullable(new MailAddress(this.value));
    }

}
