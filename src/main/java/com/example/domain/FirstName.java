package com.example.domain;

import org.seasar.doma.Domain;

import java.io.Serializable;

/**
 * 名クラス
 */
@Domain(valueType = String.class, factoryMethod = "of")
public final class FirstName implements Serializable{

    private static final long serialVersionUID = 1L;

    /** 名 */
    private final String value;

    /**
     * コンストラクタ
     *
     * @param value 名
     */
    private FirstName(final String value){
        this.value = value;
    }

    /**
     * 名を取得します。
     *
     * @return 名
     */
    public String getValue(){
        return this.value;
    }

    /**
     * FirstNameのファクトリメソッド
     *
     * @param value 名
     * @return 引数の値をラップした、FirstNameインスタンス
     */
    public static FirstName of(final String value){
        return new FirstName(value);
    }
}
