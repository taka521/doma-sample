package com.example.domain;

import org.seasar.doma.Domain;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.io.Serializable;
import java.security.MessageDigest;

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

    /**
     * パスワードをハッシュ化します。
     *
     * @return ハッシュ化後のPasswordインスタンス
     */
    public Password toHash(){
        PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder();
        return new Password(passwordEncoder.encode(value));
    }
}
