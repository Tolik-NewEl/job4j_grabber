package ru.job4j.ood.solid.srp.report;

import ru.job4j.ood.solid.srp.model.Employee;
import ru.job4j.ood.solid.srp.store.Store;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class HRReport implements Report {

    private final Store store;
    private final Comparator<Employee> comparator;

    public HRReport(Store store, Comparator<Employee> comparator) {
        this.store = store;
        this.comparator = comparator;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = store.findBy(filter);
        employees.sort(comparator);
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : employees) {
            text.append(employee.getName()).append(" ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
