package ru.job4j.ood.solid.lsp.foodstorage;

import java.time.LocalDate;

import static ru.job4j.ood.solid.lsp.foodstorage.Shop.TRASH;

public class Trash extends AbstractStore {

    private final ExpirationCalculator<LocalDate> calculator;

    public Trash(ExpirationCalculator<LocalDate> calculator) {
        this.calculator = calculator;
    }

    @Override
    protected boolean isNotExpired(Food food) {
        double percent = calculator.calculateInPercent(food.getCreateDate(), food.getExpiryDate());
        return percent >= TRASH;
    }
}
