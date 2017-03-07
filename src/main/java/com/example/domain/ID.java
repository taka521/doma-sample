package com.example.domain;

import org.seasar.doma.Domain;

import java.io.Serializable;

/**
 * IDクラス
 *
 * @param <T>
 */
@Domain(valueType = long.class, factoryMethod = "of")
public class ID<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final ID<Object> NOT_ASSIGNED = new ID<>(-1);

    private final long value;

    private ID(final long value){
        this.value = value;
    }

    public Long getValue(){
        return this.value;
    }

    public static <R> ID<R> of(final long value){
        if(value < 0) throw new IllegalArgumentException(
            "value should be positive. " + value
        );
        return new ID<>(value);
    }

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
