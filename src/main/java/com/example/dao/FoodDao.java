package com.example.dao;

import com.example.entity.Food;
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
public interface FoodDao {

    @Select(strategy = SelectType.COLLECT)
    <R> R findAll(final Collector<Food, ?, R> collector);

    @Select
    Optional<Food> findById(final long id);

    @Insert
    Result<Food> insert(final Food food);

    @Update
    Result<Food> update(final Food food);

    @Delete
    Result<Food> delete(final Food food);
}
