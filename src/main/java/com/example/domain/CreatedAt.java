package com.example.domain;

import org.seasar.doma.Domain;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 作成日時クラス
 */
@Domain(valueType = LocalDateTime.class, factoryMethod = "of")
public final class CreatedAt implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 作成日時 */
    private final LocalDateTime value;

    /**
     * コンストラクタ
     *
     * @param value 作成日時
     */
    private CreatedAt(final LocalDateTime value){
        this.value = value;
    }

    /**
     * 作成日時を取得します。
     *
     * @return 作成日時
     */
    public LocalDateTime getValue(){
        return value;
    }

    /**
     * CreatedAtのファクトリメソッドです。
     *
     * @param value 作成日時
     * @return 引数の値をラップした、CreatedAtインスタンス
     */
    public static CreatedAt of(final LocalDateTime value){
        return new CreatedAt(value);
    }

    /**
     * 現在日時が設定された作成日時インスタンスを取得します。
     *
     * @return 現在日時が設定された、作成日時インスタンス
     */
    public static CreatedAt getCurrent(){
        return new CreatedAt(LocalDateTime.now());
    }
}
