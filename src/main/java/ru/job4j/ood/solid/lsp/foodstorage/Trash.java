package ru.job4j.ood.solid.lsp.foodstorage;

import static ru.job4j.ood.solid.lsp.foodstorage.Shop.TRASH;

public class Trash extends AbstractStore {

    private LocalDateExpirationCalculator calculator = new LocalDateExpirationCalculator();

    @Override
    protected boolean isNotExpired(Food food) {
        double percent = calculator.calculateInPercent(food.getCreateDate(), food.getExpiryDate());
        return percent >= TRASH;
    }
}
