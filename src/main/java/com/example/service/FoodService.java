package com.example.service;

import com.example.dao.FoodDao;
import com.example.entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodService {

    @Autowired
    private FoodDao foodDao;

    public List<Food> findAll(){
        return foodDao.findAll(Collectors.toList());
    }

    public Optional<Food> findById(final long id){
        return foodDao.findById(id);
    }

    @Transactional
    public int insert(final Food food){
        return foodDao.insert(food).getCount();
    }

    @Transactional
    public int delete(final Food food){
        return foodDao.delete(food).getCount();
    }

    @Transactional
    public Food update(final Food food){
        return foodDao.update(food).getEntity();
    }
}
