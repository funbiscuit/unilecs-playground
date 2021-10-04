package com.funbiscuit.unilecs.task286;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class NestedInt implements NestedInteger {
    private final int value;

    public NestedInt(int value) {
        this.value = value;
    }

    @Override
    public boolean isInteger() {
        return true;
    }

    @Override
    public Integer getInteger() {
        return value;
    }

    @Override
    public List<NestedInteger> getList() {
        return null;
    }
}

class NestedList implements NestedInteger {
    private final List<NestedInteger> list;

    public NestedList(List<NestedInteger> list) {
        this.list = list;
    }

    @Override
    public boolean isInteger() {
        return false;
    }

    @Override
    public Integer getInteger() {
        return null;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}

class CustomIteratorTest {
    @Test
    void fromEmptyList() {
        CustomIterator iterator = new CustomIterator(Collections.emptyList());
        assertFalse(iterator.hasNext());
    }

    @Test
    void fromSimpleList() {
        List<NestedInteger> ints = List.of(new NestedInt(4), new NestedInt(6), new NestedInt(8));

        CustomIterator iterator = new CustomIterator(ints);

        List<Integer> expected = List.of(4, 6, 8);

        List<Integer> actual = new ArrayList<>();
        while (iterator.hasNext())
            actual.add(iterator.next());

        assertIterableEquals(expected, actual);
    }

    @Test
    void fromNestedList() {
        List<NestedInteger> ints = List.of(new NestedInt(4), new NestedInt(6), new NestedInt(8));
        List<NestedInteger> ints2 = List.of(new NestedInt(9), new NestedList(ints), new NestedInt(10));
        List<NestedInteger> ints3 = List.of(new NestedList(ints2), new NestedInt(11), new NestedInt(12));

        CustomIterator iterator = new CustomIterator(ints3);

        List<Integer> expected = List.of(9, 4, 6, 8, 10, 11, 12);

        List<Integer> actual = new ArrayList<>();
        while (iterator.hasNext())
            actual.add(iterator.next());

        assertIterableEquals(expected, actual);
    }
}