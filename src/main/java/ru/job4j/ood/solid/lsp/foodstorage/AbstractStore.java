package ru.job4j.ood.solid.lsp.foodstorage;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {

    private List<Food> store = new ArrayList<>();

    public boolean add(Food food) {
        boolean rsl = false;
        if (isNotExpired(food)) {
            store.add(food);
            rsl = true;
        }
        return rsl;
    }

    public List<Food> showAll() {
        return new ArrayList<>(store);
    }

    protected abstract boolean isNotExpired(Food food);
}