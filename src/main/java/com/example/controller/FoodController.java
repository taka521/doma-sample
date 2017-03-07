package com.example.controller;

import com.example.form.FoodForm;
import com.example.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @ModelAttribute
    FoodForm setFoodForm(){
        return new FoodForm();
    }

    @GetMapping(path = "/list")
    String findAll(final Model model){
        model.addAttribute("foods", foodService.findAll());
        return "food/list";
    }

}
