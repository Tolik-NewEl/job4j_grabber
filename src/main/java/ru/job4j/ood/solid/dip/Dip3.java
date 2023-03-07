package ru.job4j.ood.solid.dip;

import java.util.ArrayList;

public class Dip3 {
    /**
     * Возвращаемое значение - конкретная реализация.
     */
    public ArrayList<String> list() {
        return new ArrayList<>();
    }
}
