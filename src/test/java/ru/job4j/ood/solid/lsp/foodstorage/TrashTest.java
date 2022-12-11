package ru.job4j.ood.solid.lsp.foodstorage;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class TrashTest {

    @Test
    public void whenAdd() {
        Store trash = new Trash(new LocalDateExpirationCalculator());
        Food food = new Food("Apple", LocalDate.now().minusDays(10),
                LocalDate.now().minusDays(1), 10.00, 1.00);
        trash.add(food);
        List<Food> expected = trash.showAll();
        assertThat(expected.get(0).getName()).isEqualTo("Apple");
    }
}