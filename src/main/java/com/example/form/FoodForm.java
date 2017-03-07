package com.example.form;

import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;

@Data
public class FoodForm {

    private long id;

    @NotNull
    private String itemName;

    @NotNull
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private int price;

}
