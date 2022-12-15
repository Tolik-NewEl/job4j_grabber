package ru.job4j.ood.solid.lsp.parking;

public abstract class Vehicle {

    private final String name;
    private final int size;

    public Vehicle(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}