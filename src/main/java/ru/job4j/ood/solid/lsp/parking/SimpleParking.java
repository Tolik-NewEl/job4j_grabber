package ru.job4j.ood.solid.lsp.parking;

public class SimpleParking implements Parking {

    @Override
    public boolean add(Vehicle vehicle) {
        return false;
    }

    @Override
    public boolean remove(Vehicle vehicle) {
        return false;
    }
}