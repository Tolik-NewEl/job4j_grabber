package ru.job4j.ood.solid.isp.menu;

import java.util.List;

public interface MenuItem {

    String getName();

    List<MenuItem> getChildren();

    ActionDelegate getActionDelegate();
}