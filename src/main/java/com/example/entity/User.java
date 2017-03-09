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

@Entity(immutable = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    public final ID<User> id;

    public final Password password;
    public final FullName fullName;
    public final Sex sex;
    public final Optional<MailAddress> mailAddress;

    @Column(updatable = false)
    public final CreatedAt createdAt;
    public final UpdatedAt updatedAt;

    public User(ID<User> id, Password password, FullName fullName, Sex sex, Optional<MailAddress> mailAddress, CreatedAt createdAt, UpdatedAt updatedAt) {
        this.id = id;
        this.password = password;
        this.fullName = fullName;
        this.sex = sex;
        this.mailAddress = mailAddress;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
