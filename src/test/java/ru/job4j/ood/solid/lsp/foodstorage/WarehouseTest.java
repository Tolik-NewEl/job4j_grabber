package ru.job4j.ood.solid.lsp.foodstorage;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WarehouseTest {

    @Test
    public void whenAdd() {
        Store warehouse = new Warehouse();
        Food food = new Food("Apple", LocalDate.of(2022, 11, 30),
                LocalDate.of(2023, 5, 1), 100.00, 0.1);
        warehouse.add(food);
        List<Food> expected = warehouse.showAll();
        assertThat(expected.get(0).getName()).isEqualTo("Apple");
    }
}