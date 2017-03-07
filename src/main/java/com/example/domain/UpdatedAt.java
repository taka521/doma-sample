package com.example.domain;

import org.seasar.doma.Domain;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 更新日時クラス
 */
@Domain(valueType = LocalDateTime.class)
public class UpdatedAt implements Serializable {

    private static final long serialVersionUID = 1L;
    private final LocalDateTime value;

    public UpdatedAt(final LocalDateTime value){
        this.value = value;
    }

    public LocalDateTime getValue(){
        return value;
    }

    public static UpdatedAt getCurrent(){
        return new UpdatedAt(LocalDateTime.now());
    }
}
