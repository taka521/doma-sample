package com.example.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 食べ物エンティティクラス
 *
 */
@Entity(immutable = true)
public class Food implements Serializable {

    /** シリアライズバージョンUID */
    private static final long serialVersionUID = 1L;

    /** ID */
    @Id
    public final long id;

    /**  品目名 */
    public final String itemName;

    /** 価格 */
    public final int price;

    /** 作成日時 */
    @Column(insertable = false, updatable = false)
    public final LocalDateTime createdAt;

    /** 更新日時 */
    @Column(insertable = false, updatable = false)
    public final LocalDateTime updatedAt;

    public Food(long id, String itemName, int price, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
