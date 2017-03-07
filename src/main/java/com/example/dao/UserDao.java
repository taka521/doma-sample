package com.example.dao;

import com.example.entity.User;
import com.example.domain.ID;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.SelectType;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;

import java.util.Optional;
import java.util.stream.Collector;

@ConfigAutowireable
@Dao
public interface UserDao {

    @Select(strategy = SelectType.COLLECT)
    <R> R findAll(final Collector<User, ?, R> collector);

    @Select
    Optional<User> findById(final ID<User> id);

    @Update(exclude = "password")
    Result<User> update(final User user);

    @Insert
    Result<User> insert(final User user);

    @Delete
    Result<User> delete(final User user);

}
