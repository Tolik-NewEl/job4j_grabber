package ru.job4j.ood.solid.srp;

import java.util.ArrayList;
import java.util.List;

public class User {
    /**
     * Модель данных и геттеры в одном классе
     */

    private String name;
    private String sex;
    private int age;

    public User(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public void addUser(String name, String sex, int age) {
        List<User> users = new ArrayList<>();
        users.add(new User("name", "sex", 20));
    }
}
