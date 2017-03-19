package com.example.domain;

import org.seasar.doma.Domain;

import java.io.Serializable;

/**
 * 名前クラス
 */
@Domain(valueType = String.class)
public final class Name<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 名前 */
    private final String value;

    /**
     * コンストラクタ
     *
     * @param value 名前
     */
    public Name(final String value){
        this.value = value;
    }

    /**
     * 名前を取得します。
     *
     * @return 名前
     */
    public String getValue(){
        return this.value;
    }
}
