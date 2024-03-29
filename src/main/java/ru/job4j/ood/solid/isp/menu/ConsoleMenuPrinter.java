package ru.job4j.ood.solid.isp.menu;

public class ConsoleMenuPrinter implements MenuPrinter {

    private static final String INDENT = "----";

    @Override
    public void print(Menu menu) {
        for (Menu.MenuItemInfo menuItemInfo : menu) {
            int count = menuItemInfo.getNumber().split("\\.").length - 1;
            System.out.println(INDENT.repeat(count) + menuItemInfo.getNumber() + menuItemInfo.getName());
        }
    }
}
