package ru.job4j.ood.solid.lsp.parking;

import static ru.job4j.ood.solid.lsp.parking.Car.SIZE;

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
        if (isCar(vehicle) && carPlaces >= 1) {
            carParking.add(vehicle);
            carPlaces--;
            return true;
        }
        if (!isCar(vehicle) && truckPlaces >= 1) {
            truckParking.add(vehicle);
            truckPlaces--;
            return true;
        }
        if (!isCar(vehicle) && carPlaces >= vehicle.getSize()) {
            carParking.add(vehicle);
            carPlaces = carPlaces - vehicle.getSize();
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Vehicle vehicle) {
        if (isCar(vehicle) && carParking.contains(vehicle)) {
            carParking.remove(vehicle);
            carPlaces++;
            return true;
        }
        if (!isCar(vehicle) && truckParking.contains(vehicle)) {
            truckParking.remove(vehicle);
            truckPlaces++;
            return true;
        }
        if (!isCar(vehicle) && carParking.contains(vehicle)) {
            carParking.remove(vehicle);
            carPlaces = carPlaces + vehicle.getSize();
            return true;
        }
        return false;
    }

    private boolean isCar(Vehicle vehicle) {
        return vehicle.getSize() == SIZE;
    }
}