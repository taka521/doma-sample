package com.example.domain;

import org.seasar.doma.Domain;

import java.io.Serializable;

/**
 * 姓クラス
 */
@Domain(valueType = String.class, factoryMethod = "of")
public final class LastName implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 姓 */
    private final String value;

    /**
     * コンストラクタ
     *
     * @param value 性
     */
    private LastName(final String value){
        this.value = value;
    }

    /**
     * 姓を取得します。
     *
     * @return 姓
     */
    public String getValue(){
        return this.value;
    }

    /**
     * LastNameのファクトリメソッド
     *
     * @param value 姓
     * @return 引数の値をラップした、LastNameインスタンス
     */
    public static LastName of(final String value){
        return new LastName(value);
    }

}
