package com.example.embeddable;

import com.example.domain.FirstName;
import com.example.domain.LastName;
import org.seasar.doma.Embeddable;

import java.io.Serializable;

/**
 * 姓名クラス
 */
@Embeddable
public final class FullName implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 名 */
    private final FirstName firstName;

    /** 姓 */
    private final LastName lastName;

    /**
     * 姓名クラスのインスタンス
     *
     * @param firstName 名
     * @param lastName 姓
     */
    public FullName(final FirstName firstName, final LastName lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * 名を取得します。
     *
     * @return 名
     */
    public FirstName getFirstName(){
        return this.firstName;
    }

    /**
     * 姓を取得します
     *
     * @return 姓
     */
    public LastName getLastName(){
        return this.lastName;
    }

}
