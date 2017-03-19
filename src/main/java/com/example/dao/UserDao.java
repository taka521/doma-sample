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

    /**
     * 全件検索を行います。
     *
     * @param collector
     * @param <R>
     * @return
     */
    @Select(strategy = SelectType.COLLECT)
    <R> R findAll(final Collector<User, ?, R> collector);

    /**
     * id検索を行います。
     *
     * @param id id
     * @return 検索結果
     */
    @Select
    Optional<User> findById(final ID<User> id);

    /**
     * ユーザの更新を行います。
     *
     * @param user 更新対象のUserインスタンス
     * @return 更新を行ったUserインスタンス
     */
    @Update(sqlFile = true)
    Result<User> update(final User user);

    /**
     * ユーザの登録を行います。
     *
     * @param user 登録対象のUserインスタンス
     * @return 登録したUserインスタンス
     */
    @Insert(sqlFile = true)
    Result<User> insert(final User user);

    /**
     * ユーザの削除を行います。
     *
     * @param user 削除対象のUserインスタンス
     * @return 削除したUserインスタンス
     */
    @Delete
    Result<User> delete(final User user);

}
