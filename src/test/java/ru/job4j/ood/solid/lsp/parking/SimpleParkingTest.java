package ru.job4j.ood.solid.lsp.parking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SimpleParkingTest {

    @Test
    public void whenAdd2CarsAnd1TruckThanOK() {
        Parking sp = new SimpleParking(2, 1);
        Vehicle car1 = new Car("mazda");
        Vehicle car2 = new Car("BMW");
        Vehicle truck = new Truck("MAN", 2);
        sp.add(car1);
        sp.add(car2);
        assertThat(sp.add(truck)).isTrue();
    }

    @Test
    public void whenAdd1CarAnd1TruckThanOK() {
        Parking sp = new SimpleParking(1, 1);
        Vehicle car = new Car("mazda");
        Vehicle truck = new Truck("MAN", 2);
        sp.add(car);
        assertThat(sp.add(truck)).isTrue();
    }

    @Test
    public void whenAdd1CarAnd2TruckThanFail() {
        Parking sp = new SimpleParking(1, 1);
        Vehicle car = new Car("mazda");
        Vehicle truck1 = new Truck("MAN", 2);
        Vehicle truck2 = new Truck("Iveco", 3);
        sp.add(car);
        sp.add(truck1);
        assertThat(sp.add(truck2)).isFalse();
    }

    @Test
    public void whenAdd0CarAnd1TruckThanOK() {
        Parking sp = new SimpleParking(1, 1);
        Vehicle truck = new Truck("MAN", 2);
        assertThat(sp.add(truck)).isTrue();
    }

    @Test
    public void  whenAdd2CarAnd1TruckThanFail() {
        Parking sp = new SimpleParking(2, 1);
        Vehicle car = new Car("mazda");
        Vehicle truck1 = new Truck("MAN", 2);
        Vehicle truck2 = new Truck("Iveco", 2);
        sp.add(car);
        sp.add(truck1);
        assertThat(sp.add(truck2)).isFalse();
    }

    @Test
    public void whenAddAndRemoveThanOK() {
        Parking sp = new SimpleParking(1, 1);
        Vehicle car = new Car("mazda");
        sp.add(car);
        assertThat(sp.remove(car)).isTrue();
    }

    @Test
    public void whenAdd2AndRemove1ThanOK() {
        Parking sp = new SimpleParking(2, 0);
        Vehicle car1 = new Car("mazda");
        Vehicle car2 = new Car("BMW");
        sp.add(car1);
        sp.add(car2);
        assertThat(sp.remove(car2)).isTrue();
    }

    @Test
    public void whenAdd1AndRemove2ThanFail() {
        Parking sp = new SimpleParking(2, 0);
        Vehicle car1 = new Car("mazda");
        Vehicle car2 = new Car("BMW");
        sp.add(car1);
        assertThat(sp.remove(car2)).isFalse();
    }

    @Test
    public void whenAddCarOnTruckPlaceThanFail() {
        Parking sp = new SimpleParking(1, 1);
        Vehicle car1 = new Car("mazda");
        Vehicle car2 = new Car("BMW");
        sp.add(car1);
        assertThat(sp.add(car2)).isFalse();
    }
}