package com.example.domain;

import org.seasar.doma.Domain;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 更新日時クラス
 */
@Domain(valueType = LocalDateTime.class, factoryMethod = "of")
public final class UpdatedAt implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 更新日時 */
    private final LocalDateTime value;

    /**
     * コンストラクタです。
     *
     * @param value 更新日時
     */
    private UpdatedAt(final LocalDateTime value){
        this.value = value;
    }

    /**
     * UpdatedAtのファクトリメソッドです。
     *
     * @param value 更新日時
     * @return 引数の値でラップした、UpdatedAtインスタンス
     */
    public static UpdatedAt of(final LocalDateTime value){
        return new UpdatedAt(value);
    }

    /**
     * 更新日時を取得します。
     *
     * @return 更新日時
     */
    public LocalDateTime getValue(){
        return value;
    }

    /**
     * 現在日時を設定した、UpdatedAtインスタンスを取得します。
     *
     * @return 現在日時を設定した、UpdatedAtインスタンス
     */
    public static UpdatedAt getCurrent(){
        return new UpdatedAt(LocalDateTime.now());
    }
}
