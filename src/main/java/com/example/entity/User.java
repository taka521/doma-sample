package com.example.entity;

import com.example.domain.CreatedAt;
import com.example.domain.ID;
import com.example.domain.MailAddress;
import com.example.domain.Password;
import com.example.domain.Sex;
import com.example.domain.UpdatedAt;
import com.example.embeddable.FullName;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;

import java.io.Serializable;
import java.util.Optional;

/**
 * Userエンティティ
 */
@Entity(immutable = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ユーザid */
    @Id
    public final ID<User> id;

    /** パスワード */
    public final Password password;

    /** 姓名 */
    public final FullName fullName;

    /** 性別 */
    public final Sex sex;

    /** メールアドレス */
    public final Optional<MailAddress> mailAddress;

    /** 作成日時 */
    @Column(updatable = false)
    public final CreatedAt createdAt;

    /** 更新日時 */
    public final UpdatedAt updatedAt;

    /**
     * コンストラクタです。
     *
     * @param id ユーザid
     * @param password パスワード
     * @param fullName 姓名
     * @param sex 性別
     * @param mailAddress メールアドレス
     * @param createdAt 作成日時
     * @param updatedAt 更新日時
     */
    public User(ID<User> id, Password password, FullName fullName, Sex sex,
                Optional<MailAddress> mailAddress, CreatedAt createdAt, UpdatedAt updatedAt) {
        this.id = id;
        this.password = password;
        this.fullName = fullName;
        this.sex = sex;
        this.mailAddress = mailAddress;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
