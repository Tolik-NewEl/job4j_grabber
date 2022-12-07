package ru.job4j.ood.solid.lsp.foodstorage;

import java.util.ArrayList;
import java.util.List;

public class Warehouse extends AbstractStore {

    List<Food> warehouse = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        double expDays = dispatch(food);
        if (expDays > GOOD) {
            warehouse.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Food> showAll() {
        return warehouse;
    }
}
