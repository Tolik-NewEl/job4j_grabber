package ru.job4j.ood.solid.lsp.parking;

public class Car extends Vehicle {

    public static final int SIZE = 1;

    public Car(String name) {
        super(name, SIZE);
    }
}