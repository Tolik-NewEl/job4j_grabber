package ru.job4j.ood.solid.srp;

public class PetExample implements Pet {
    /**
     * Реализуем интерфейс с двумя методами. Следуя принципу SRP -
     * лучше реализовать в двух отдельных классах.
     */

    @Override
    public void walk() {
    }

    @Override
    public Object makePhoto() {
        return null;
    }
}