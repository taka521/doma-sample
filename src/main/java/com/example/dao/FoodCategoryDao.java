package com.example.dao;

import com.example.entity.FoodCategory;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.SelectType;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.stream.Collector;

@ConfigAutowireable
@Dao
public interface FoodCategoryDao {

    @Select(strategy = SelectType.COLLECT)
    <R> R findAll(final Collector<FoodCategory, ?, R> collector);

}
