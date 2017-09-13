package com.example.service;

import com.example.controller.result.FoodResult;
import com.example.dao.FoodCategoryDao;
import com.example.dao.FoodDao;
import com.example.entity.Food;
import com.example.entity.FoodCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodService {

    @Autowired
    private FoodDao foodDao;

    @Autowired
    private FoodCategoryDao foodCategoryDao;

    public List<Food> findAll() {
        return foodDao.findAll(Collectors.toList());
    }

    public List<FoodResult> getFoodResultList() {

        List<Food> foods = foodDao.findAll(Collectors.toList());
        List<FoodCategory> categories = foodCategoryDao.findAll(Collectors.toList());

        List<FoodResult> results = new ArrayList<>();

        for (FoodCategory category : categories) {
            FoodResult foodResult = new FoodResult();
            foodResult.setFoodCategory(category);

            for (Food food : foods) {
                foodResult.setFoods(foods.stream().filter(f -> f.categoryId == category.getCategoryId())
                                         .collect(Collectors.toList()));
            }
            results.add(foodResult);
        }

        return results;
    }

    public Optional<Food> findById(final long id) {
        return foodDao.findById(id);
    }

    @Transactional
    public int insert(final Food food) {
        return foodDao.insert(food).getCount();
    }

    @Transactional
    public int delete(final Food food) {
        return foodDao.delete(food).getCount();
    }

    @Transactional
    public Food update(final Food food) {
        return foodDao.update(food).getEntity();
    }
}
