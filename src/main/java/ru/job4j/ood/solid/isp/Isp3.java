package ru.job4j.ood.solid.isp;

public interface Isp3 {
    /**
     * Интерфейс для реализации персонажей RPG
     * Не все типы персонажей могут лечить/атаковать/колдовать
     */
    void attack();
    void heal();
    void castSpell();
}
