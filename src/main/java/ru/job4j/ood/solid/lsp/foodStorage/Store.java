package ru.job4j.ood.solid.lsp.foodStorage;

import java.util.List;

public interface Store {

    boolean add(Food food);

    List<Food> showAll();
}
