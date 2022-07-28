package ru.job4j.cache;

import java.util.Scanner;

public class Emulator {
    private final DirFileCache dirFileCache;
    private static final int LOAD_CACHE = 1;
    private static final int GET_CACHE = 2;
    private static final String MENU =
        "Выберите действие:\n"
        + "1 - загрузить содержимое файла в кэш;\n"
        + "2 - получить содержимое файла из кэша;\n"
        + "Любой другой выбор - выход.";

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
            System.out.println(MENU);
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == LOAD_CACHE || choice == GET_CACHE) {
                System.out.print("Введите имя файла: ");
                fileName = scanner.nextLine();
                switch (choice) {
                    case LOAD_CACHE:
                        emulator.load(fileName);
                        break;
                    case GET_CACHE:
                        System.out.println(emulator.getCache(fileName));
                        break;
                    default:
                        run = false;
                        break;
                }
            } else {
                System.out.println("Ошибка выбора! Выход.");
                break;
            }
        }
    }
}
