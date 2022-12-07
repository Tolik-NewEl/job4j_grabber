package ru.job4j.ood.solid.lsp.foodstorage;

import java.util.List;

public interface Store {

    boolean add(Food food);

    List<Food> showAll();
}
