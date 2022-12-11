package ru.job4j.ood.solid.lsp.foodstorage;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {

    @Test
    public void whenAddAllTypeOfFoods() {
        Store warehouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();
        List<Store> stores = new ArrayList<>(List.of(warehouse, shop, trash));
        ControlQuality cq = new ControlQuality(stores);
        Food food1 = new Food("Apple", LocalDate.now(),
                LocalDate.now().plusDays(10), 100, 0.1);
        Food food2 = new Food("Cheese", LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(1), 100.00, 0.1);
        Food food3 = new Food("Bread", LocalDate.now().minusDays(10),
                LocalDate.now().minusDays(1), 100.00, 0.1);
        cq.add(food1);
        cq.add(food2);
        cq.add(food3);
        assertThat(warehouse.showAll().get(0)).isEqualTo(food1);
        assertThat(shop.showAll().get(0)).isEqualTo(food2);
        assertThat(trash.showAll().get(0)).isEqualTo(food3);
    }

}