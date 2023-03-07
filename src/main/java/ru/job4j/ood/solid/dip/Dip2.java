package ru.job4j.ood.solid.dip;

import java.util.HashMap;
import java.util.Map;

public class Dip2 {
    /**
     * В аргумент конструктора передаем конкретную реализацию
     */
    private Map<Integer, String> map;

    public Dip2(HashMap<Integer, String> map) {
        this.map = map;
    }
}
