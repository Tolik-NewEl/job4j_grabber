package ru.job4j.ood.solid.lsp.foodstorage;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ShopTest {

    @Test
    public void whenAdd() {
        Store shop = new Shop(new LocalDateExpirationCalculator());
        Food food = new Food("Apple", LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(10), 100.00, 0.1);
        shop.add(food);
        List<Food> expected = shop.showAll();
        assertThat(expected.get(0).getName()).isEqualTo("Apple");
    }

    @Test
    public void whenDiscountAndAdd() {
        Store shop = new Shop(new LocalDateExpirationCalculator());
        Food food = new Food("Apple", LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(1), 100.00, 0.95);
        shop.add(food);
        List<Food> expected = shop.showAll();
        assertThat(expected.get(0).getPrice()).isEqualTo(95);
    }
}