package ru.job4j.ood.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return compareValues(value, (e1, e2) -> comparator.compare(e1, e2) >= 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return compareValues(value, (e1, e2) -> comparator.compare(e1, e2) <= 0);
    }

    private <T> T compareValues(List<T> value, BiPredicate<T, T> predicate) {
        if (value.isEmpty()) {
            return null;
        }
        T rsl = value.get(0);
        for (T e : value) {
            rsl = predicate.test(rsl, e) ? rsl : e;
            }
        return rsl;
    }
}
