package com.example.domain;

import java.io.Serializable;

public class AbstractDomain<T> implements Serializable {

    private final T value;

    public AbstractDomain(final T value){
        this.value = value;
    }

    public T getValue(){
        return this.value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractDomain<?> that = (AbstractDomain<?>) o;

        return value != null ? value.equals(that.value) : that.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

}
