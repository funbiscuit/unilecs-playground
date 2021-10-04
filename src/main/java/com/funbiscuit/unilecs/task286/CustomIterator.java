package com.funbiscuit.unilecs.task286;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

interface NestedInteger {
    boolean isInteger();

    Integer getInteger();

    List<NestedInteger> getList();
}

public class CustomIterator {
    List<Integer> list = new ArrayList<>();
    Iterator<Integer> iterator;

    public CustomIterator(List<NestedInteger> nestedList) {
        nestedList.forEach(this::flatten);
        iterator = list.iterator();
    }

    private void flatten(NestedInteger v) {
        if (v.isInteger()) {
            list.add(v.getInteger());
        } else {
            v.getList().forEach(this::flatten);
        }
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public int next() {
        return iterator.next();
    }
}
