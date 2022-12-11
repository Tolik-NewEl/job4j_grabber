package ru.job4j.ood.solid.lsp.foodstorage;

public interface ExpirationCalculator<T> {

    double calculateInPercent(T startDate, T endDate);
}
