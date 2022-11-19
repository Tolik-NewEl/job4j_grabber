package ru.job4j.ood.solid.ocp;

import java.util.ArrayList;

public class PhoneBook {
    /**
     * Нарушение OCP - поля и возвращаемый тип должны
     * быть реализованы через абстракцию
     */
    ArrayList<Integer> list;

    private ArrayList<Integer> addPhone(Integer phone) {
        list.add(phone);
        return list;
    }
}
