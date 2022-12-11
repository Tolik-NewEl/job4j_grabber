package ru.job4j.ood.solid.lsp.foodstorage;

import java.time.LocalDate;

import static ru.job4j.ood.solid.lsp.foodstorage.Shop.WAREHOUSE;

public class Warehouse extends AbstractStore {

    private final ExpirationCalculator<LocalDate> calculator;

    public Warehouse(ExpirationCalculator<LocalDate> calculator) {
        this.calculator = calculator;
    }

    @Override
    protected boolean isNotExpired(Food food) {
        double percent = calculator.calculateInPercent(food.getCreateDate(), food.getExpiryDate());
        return percent <= WAREHOUSE;
    }
}
