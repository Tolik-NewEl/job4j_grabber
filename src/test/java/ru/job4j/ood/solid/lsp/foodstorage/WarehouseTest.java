package ru.job4j.ood.solid.lsp.foodstorage;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WarehouseTest {

    @Test
    public void whenAdd() {
        Store warehouse = new Warehouse(new LocalDateExpirationCalculator());
        Food food = new Food("Apple", LocalDate.now(),
                LocalDate.now().plusDays(10), 100.00, 0.1);
        warehouse.add(food);
        List<Food> expected = warehouse.showAll();
        assertThat(expected.get(0).getName()).isEqualTo("Apple");
    }
}