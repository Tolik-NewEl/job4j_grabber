package ru.job4j.ood.solid.lsp.parking;

import java.util.HashSet;
import java.util.Set;

public class SimpleParking implements Parking {

    private int carPlaces;
    private int truckPlaces;
    private Set<Vehicle> carParking;
    private Set<Vehicle> truckParking;

    public SimpleParking(int carPlaces, int truckPlaces) {
        this.carPlaces = carPlaces;
        this.truckPlaces = truckPlaces;
        carParking = new HashSet<>(carPlaces);
        truckParking = new HashSet<>(truckPlaces);
    }

    @Override
    public boolean add(Vehicle vehicle) {
        return false;
    }

    @Override
    public boolean remove(Vehicle vehicle) {
        return false;
    }
}