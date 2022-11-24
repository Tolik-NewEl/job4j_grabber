package ru.job4j.ood.solid.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.ood.solid.srp.model.Employee;
import ru.job4j.ood.solid.srp.store.Store;

import java.util.function.Predicate;

public class JSONReport implements Report {

    private final Store store;
    private final Gson gson;

    public JSONReport(Store store) {
        this.store = store;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return gson.toJson(store.findBy(filter));
    }
}