package ru.job4j.ood.solid.lsp.foodStorage;

import java.util.List;

public class ControlQuality {

    private final List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void add(Food food) {
        for (Store store : stores) {
            store.add(food);
        }
    }
}
