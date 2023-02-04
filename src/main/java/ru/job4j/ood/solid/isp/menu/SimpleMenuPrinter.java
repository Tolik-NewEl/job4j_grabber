package ru.job4j.ood.solid.isp.menu;

public class SimpleMenuPrinter implements MenuPrinter {

    @Override
    public void print(Menu menu) {
        for (Menu.MenuItemInfo menuItemInfo : menu) {
            int count = menuItemInfo.getNumber().split("\\.").length - 1;
            System.out.println("----".repeat(count) + menuItemInfo.getNumber() + menuItemInfo.getName());
        }
    }
}
