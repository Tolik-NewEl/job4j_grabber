package ru.job4j.ood.solid.srp.formatter;

public interface DateTimeParser<T> {
    String parse(T t);
}
