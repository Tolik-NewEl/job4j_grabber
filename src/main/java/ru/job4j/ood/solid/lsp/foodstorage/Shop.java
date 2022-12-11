package ru.job4j.ood.solid.lsp.foodstorage;

import java.time.LocalDate;

public class Shop extends AbstractStore {

    public static final double WAREHOUSE = 25;
    public static final double TRASH = 100;
    private static final double DISCOUNT = 75;
    private final ExpirationCalculator<LocalDate> calculator;

    public Shop(ExpirationCalculator<LocalDate> calculator) {
        this.calculator = calculator;
    }

    @Override
    protected boolean isNotExpired(Food food) {
        boolean rsl = false;
        double percent = calculator.calculateInPercent(food.getCreateDate(), food.getExpiryDate());
        if (percent > WAREHOUSE && percent < TRASH) {
            if (percent > DISCOUNT) {
                setDiscount(food);
            }
            rsl = true;
        }
        return rsl;
    }

    private void setDiscount(Food food) {
        food.setPrice(food.getPrice() * food.getDiscount());
    }
}
