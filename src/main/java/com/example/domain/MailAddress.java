package com.example.domain;

import org.seasar.doma.Domain;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Optional;

/**
 * メールアドレスクラス
 */
@Domain(valueType = String.class, factoryMethod = "of")
public final class MailAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    /** メールアドレス */
    private final String value;

    /**
     * コンストラクタです。
     *
     * @param value メールアドレス
     */
    private MailAddress(final String value){
        this.value = value;
    }

    /**
     * メールアドレスを取得します。
     *
     * @return メールアドレス
     */
    public String getValue(){
        return this.value;
    }

    /**
     * MailAddressのファクトリメソッドです。
     *
     * @param value メールアドレス
     * @return 引数の値をラップした、MailAddressインスタンス
     */
    public static MailAddress of(final String value){
        return new MailAddress(value);
    }

    /**
     * Optionalへ変換します。
     * <p>
     * 内部的に保持している値がnull、もしくは空文字出の場合には<br/>
     * <pre>Optional.empty()</pre>を返却します。
     * </p>
     *
     * @return OptionalでラップしたMailAddressインスタンス
     */
    @SuppressWarnings("unchecked")
    public Optional<MailAddress> toOptional(){
        if(StringUtils.isEmpty(this.value)){
            return Optional.empty();
        }
        return Optional.ofNullable(this);
    }

}
