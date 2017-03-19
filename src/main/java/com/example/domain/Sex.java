package com.example.domain;

import org.seasar.doma.Domain;

import java.io.Serializable;

/**
 * 性別列挙体
 */
@Domain(valueType = String.class, factoryMethod = "of")
public enum Sex implements Serializable {

    /** 男性 */
    MALE("0"),

    /** 女性 */
    FEMALE("1");

    private static final long serialVersionUID = 1L;

    /** 性別 */
    private final String value;

    /**
     * コンストラクタ
     *
     * @param value 性別
     */
    private Sex(final String value){
        this.value = value;
    }

    /**
     * 性別を取得します。
     *
     * @return "0":男性、"1":女性
     */
    public String getValue(){
        return this.value;
    }

    /**
     * Sexのファクトリメソッドです。
     * <p>
     * 引数の値に一致するSex列挙体が見つからない場合、
     * <pre>IllegalArgumentException</pre>がスローされます。
     * </p>
     *
     * @param value 性別
     * @return 引数の値に一致する、Sexインスタンス
     * @throws IllegalArgumentException
     */
    public static Sex of(final String value) throws IllegalArgumentException {
        for(Sex sex : Sex.values()){
            if(sex.getValue().equals(value)){
                return sex;
            }
        }

        throw new IllegalArgumentException(value);
    }
}
