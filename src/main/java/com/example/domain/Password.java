package com.example.domain;

import org.seasar.doma.Domain;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.io.Serializable;

/**
 * パスワードクラス
 */
@Domain(valueType = String.class, factoryMethod = "of")
public final class Password implements Serializable {

    private static final long serialVersionUID = 1L;

    /** パスワード */
    private final String value;

    /**
     * コンストラクタ
     *
     * @param value パスワード
     */
    private Password(final String value){
        this.value = value;
    }

    /**
     * パスワードを取得します。
     *
     * @return パスワード
     */
    public String getValue(){
        return this.value;
    }

    /**
     * Passwordのファクトリメソッドです。
     *
     * @param value パスワード
     * @return 引数の値をラップした、Passwordインスタンス
     */
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
