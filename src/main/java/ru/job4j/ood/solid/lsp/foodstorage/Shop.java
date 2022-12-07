package ru.job4j.ood.solid.lsp.foodstorage;

import java.util.ArrayList;
import java.util.List;

public class Shop extends AbstractStore {

    List<Food> shop = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        double expDays = dispatch(food);
        if (expDays >= BETTER && expDays <= GOOD) {
            shop.add(food);
            rsl = true;
        }
        if (expDays < BETTER && expDays > 0) {
            food.setPrice(food.getPrice() * food.getDiscount());
            shop.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Food> showAll() {
        return shop;
    }
}
