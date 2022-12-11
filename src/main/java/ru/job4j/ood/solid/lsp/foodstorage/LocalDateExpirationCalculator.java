package ru.job4j.ood.solid.lsp.foodstorage;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class LocalDateExpirationCalculator implements ExpirationCalculator<LocalDate> {

    @Override
    public double calculateInPercent(LocalDate startDate, LocalDate endDate) {
        return 100 - ((DAYS.between(endDate, LocalDate.now()) * 100)
                / (DAYS.between(endDate, startDate)));
    }
}
