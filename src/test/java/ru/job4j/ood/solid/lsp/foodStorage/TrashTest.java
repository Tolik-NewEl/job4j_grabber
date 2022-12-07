package ru.job4j.ood.solid.lsp.foodStorage;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class TrashTest {

    @Test
    public void whenAdd() {
        Store trash = new Trash();
        Food food = new Food("Apple", LocalDate.of(2022, 12, 1),
                LocalDate.of(2022, 12, 5), 10.00, 1.00);
        trash.add(food);
        List<Food> expected = trash.showAll();
        assertThat(expected.get(0).getName()).isEqualTo("Apple");
    }
}