package ru.job4j.ood.solid.lsp.parking;

public interface Parking {

    boolean add(Vehicle vehicle);

    boolean remove(Vehicle vehicle);
}