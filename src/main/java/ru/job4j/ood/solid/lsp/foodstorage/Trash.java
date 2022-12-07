package ru.job4j.ood.solid.lsp.foodstorage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class Trash extends AbstractStore {

    List<Food> trash = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        if (DAYS.between(LocalDate.now(), food.getExpiryDate()) <= 0) {
            trash.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Food> showAll() {
        return trash;
    }
}
