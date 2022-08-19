package ru.job4j.ood.kiss;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class MaxMinTest {

    @Test
    public void whenMax() {
        List<Integer> rsl = List.of(1, 2, 3, 4, 5);
        Comparator<Integer> comparator = Integer::compareTo;
        assertThat(new MaxMin().max(rsl, comparator), is(5));
    }

    @Test
    public void whenMin() {
        List<Integer> rsl = List.of(1, 2, 3, 4, 5);
        Comparator<Integer> comparator = Integer::compareTo;
        assertThat(new MaxMin().min(rsl, comparator), is(1));
    }

    @Test
    public void whenEmpty() {
        List<Integer> rsl = new ArrayList<>();
        Comparator<Integer> comparator = Integer::compareTo;
        assertThat(new MaxMin().min(rsl, comparator), is(nullValue()));
    }
}