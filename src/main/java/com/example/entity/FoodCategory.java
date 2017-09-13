package com.example.entity;

import org.seasar.doma.Entity;

import java.sql.Timestamp;

@Entity(immutable = true)
public class FoodCategory {

    private final int categoryId;
    private final String categoryName;
    private final Timestamp createdAt;
    private final Timestamp updatedAt;

    public FoodCategory(int categoryId, String categoryName, Timestamp createdAt, Timestamp updatedAt) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }
}
