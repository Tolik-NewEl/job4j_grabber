package ru.job4j.ood.solid.lsp.parking;

import static ru.job4j.ood.solid.lsp.parking.Car.SIZE;

public class Truck extends Vehicle {

    public Truck(String name, int size) {
        super(name, size);
        if (size <= SIZE) {
            throw new IllegalArgumentException("Truck size too small!");
        }
    }
}