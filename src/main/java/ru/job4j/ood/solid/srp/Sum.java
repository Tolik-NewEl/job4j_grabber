package ru.job4j.ood.solid.srp;

public class Sum {
    /**
     * В классе два метода с различной целью - нарушение SRP
     */

    public int sum(int a, int b) {
        return a + b;
    }

    public void printSum(String message) {
    }
}
