package ru.job4j.cache;

import java.util.Scanner;

public class Emulator {
    private final DirFileCache dirFileCache;

    public Emulator(String dirFileCache) {
        this.dirFileCache = new DirFileCache(dirFileCache);
    }

    public void load(String key) {
        dirFileCache.load(key);
    }

    public String getCache(String key) {
        return dirFileCache.get(key);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Укажите путь кэшируемой директории: ");
        String dirFileCache = scanner.nextLine();
        Emulator emulator = new Emulator(dirFileCache);
        boolean run = true;
        String fileName;
        while (run) {
            System.out.println("Выберите действие");
            System.out.println("1 - загрузить содержимое файла в кэш");
            System.out.println("2 - получить содержимое файла из кэша");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1 || choice == 2) {
                System.out.print("Введите имя файла: ");
                fileName = scanner.nextLine();
                switch (choice) {
                    case 1 -> emulator.load(fileName);
                    case 2 -> System.out.println(emulator.getCache(fileName));
                    default -> run = false;
                }
            } else {
                System.out.println("Ошибка выбора!");
                break;
            }
        }
    }
}
