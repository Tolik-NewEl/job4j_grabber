package ru.job4j.ood.solid.srp;

public class Singleton {
    /**
     * Шаблон Синглтон нарушает SRP, т.к. помимо создания объекта
     * проверяет его на наличие ранее созданного объекта
     */

    private static Singleton instance;

    private Singleton() {
    }

    private static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
