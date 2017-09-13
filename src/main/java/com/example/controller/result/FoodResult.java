package com.example.controller.result;

import com.example.entity.Food;
import com.example.entity.FoodCategory;
import lombok.Data;


import java.util.List;

@Data
public class FoodResult {

    private FoodCategory foodCategory;
    private List<Food> foods;

}
