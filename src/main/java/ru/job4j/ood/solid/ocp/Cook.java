package ru.job4j.ood.solid.ocp;

public class Cook {
    /**
     * Нарушает принцип OCP - если захотим готовить мясо - придется
     * добавить новый метод.
     */
    public void fishCook() {
        System.out.println("Готовим рыбу");
    }
}
