package ru.job4j.ood.solid.lsp.foodStorage;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public abstract class AbstractStore implements Store{

    public static final double BETTER = 25.00;
    public static final double GOOD = 75.00;

    public static double dispatch(Food food) {
        return (DAYS.between(food.getExpiryDate(), LocalDate.now()) * 100.00)
                / DAYS.between(food.getExpiryDate(), food.getCreateDate());
    }
}
