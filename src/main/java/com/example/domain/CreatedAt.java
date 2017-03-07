package com.example.domain;

import org.seasar.doma.Domain;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 作成日時クラス
 */
@Domain(valueType = LocalDateTime.class)
public class CreatedAt implements Serializable{

    private static final long serialVersionUID = 1L;
    private final LocalDateTime value;

    public CreatedAt(final LocalDateTime value){
        this.value = value;
    }

    public LocalDateTime getValue(){
        return value;
    }

    public static CreatedAt getCurrent(){
        return new CreatedAt(LocalDateTime.now());
    }
}
