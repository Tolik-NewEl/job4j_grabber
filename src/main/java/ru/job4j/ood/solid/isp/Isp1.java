package ru.job4j.ood.solid.isp;

public interface Isp1 {
    /**
     * Интерфейс для реализации транспортных средств
     * Лишний метод fuel() для электрокара
     */
    void start();
    void stop();
    void fuel();
}
