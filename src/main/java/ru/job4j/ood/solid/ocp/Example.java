package ru.job4j.ood.solid.ocp;

public class Example {
    /**
     * Нарушение OCP - прямая зависимость от другого класса
     */
    private Cook cook;

    public Example(Cook cook) {
        this.cook = cook;
    }
}
