package ru.job4j.ood.solid.lsp.foodstorage;

public class Shop extends AbstractStore {

    private LocalDateExpirationCalculator calculator = new LocalDateExpirationCalculator();
    public static double WAREHOUSE = 25;
    public static double TRASH = 100;
    private static final double DISCOUNT = 75;

    @Override
    protected boolean isNotExpired(Food food) {
        boolean rsl = false;
        double percent = calculator.calculateInPercent(food.getCreateDate(), food.getExpiryDate());
        if (percent > WAREHOUSE && percent < TRASH) {
            if (percent > DISCOUNT) {
                discount(food);
            }
            rsl = true;
        }
        return rsl;
    }

    public void discount(Food food) {
        food.setPrice(food.getPrice() * food.getDiscount());
    }
}
