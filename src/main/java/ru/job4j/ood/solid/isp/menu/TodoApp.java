package ru.job4j.ood.solid.isp.menu;

import java.util.Scanner;

public class TodoApp {

    private static final String ADD_ROOT = "1.Добавить элемент в корень меню";
    private static final String ADD_CHILD = "2.Добавить элемент к родительскому элементу";
    private static final String SOME_ACTION = "3.Вывод приветствия";
    private static final String PRINT_MENU = "4.Печать меню";
    private static final String EXIT = "Для выхода - любая другая цифра";
    private static final String MENU = String.join(System.lineSeparator(),
            ADD_ROOT, ADD_CHILD, SOME_ACTION, PRINT_MENU, EXIT + System.lineSeparator());
    private static final String ASK = "Выберите пункт меню ";
    public static final ActionDelegate DEFAULT_ACTION = () -> System.out.println("Hello!");
    public static final ActionDelegate STUB_ACTION = System.out::println;

    public static void main(String[] args) {
        Menu menu = new SimpleMenu();
        MenuPrinter printer = new SimpleMenuPrinter();
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        String name;
        while (run) {
            System.out.println(MENU);
            System.out.println(ASK);
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Укажите имя элемента: ");
                    name = sc.nextLine();
                    menu.add(Menu.ROOT, name, STUB_ACTION);
                    break;
                case 2:
                    System.out.println("Укажите имя родительского элемента: ");
                    name = sc.nextLine();
                    System.out.println("Укажите имя добавляемого элемента: ");
                    String child = sc.nextLine();
                    menu.add(name, child, STUB_ACTION);
                    break;
                case 3:
                    DEFAULT_ACTION.delegate();
                    break;
                case 4:
                    printer.print(menu);
                    break;
                default:
                    System.out.println("Программа завершена!");
                    run = false;
            }
        }
    }
}
