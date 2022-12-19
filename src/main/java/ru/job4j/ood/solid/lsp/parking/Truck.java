package ru.job4j.ood.solid.lsp.parking;

public class Truck extends Vehicle {

    public Truck(String name, int size) {
        super(name, size);
        if (size <= 1) {
            throw new IllegalArgumentException("Truck size too small!");
        }
    }
}