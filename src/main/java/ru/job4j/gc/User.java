package ru.job4j.gc;

public class User {

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %n");
    }
}
