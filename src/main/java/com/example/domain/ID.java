package com.example.domain;

import org.seasar.doma.Domain;

import java.io.Serializable;

/**
 * IDクラス
 */
@Domain(valueType = long.class, factoryMethod = "of")
public final class ID<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 未割当を表します */
    private static final ID<Object> NOT_ASSIGNED = new ID<>(-1);

    /** id */
    private final long value;

    /**
     * コンストラクタ
     *
     * @param value id
     */
    private ID(final long value){
        this.value = value;
    }

    /**
     * idを取得します。
     *
     * @return id
     */
    public Long getValue(){
        return this.value;
    }

    /**
     * IDクラスのファクトリメソッドです。
     * <p>
     * 引数に0よりも小さい値を設定した場合、<pre>IllegalArgumentException</pre>がスローされます。<br/>
     * 未割り当て用のインスタンスを生成したい場合には、
     * staticメソッド{@code notAssigned}を呼び出して、未割当のインスタンスを取得してください。
     * </p>
     *
     * @param value id
     * @return 引数の値をラップした、IDインスタンス
     */
    public static <R> ID<R> of(final long value){
        if(value < 0) throw new IllegalArgumentException(
            "value should be positive. " + value
        );
        return new ID<>(value);
    }

    /**
     * 未割り当てを表すIDインスタンスを取得します。
     *
     * @return 未割り当てを表すIDインスタンス
     */
    @SuppressWarnings("unchecked")
    public static <R> ID<R> notAssigned() {
        return (ID<R>) NOT_ASSIGNED;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == NOT_ASSIGNED) return false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final ID<?> id = (ID<?>) o;
        return value == id.value;
    }

    @Override
    public int hashCode() {
        return (int) (value ^ (value >>> 32));
    }

}
