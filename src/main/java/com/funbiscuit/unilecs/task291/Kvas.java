package com.funbiscuit.unilecs.task291;

import java.util.*;

public class Kvas {

    private final SortedMap<Integer, Integer> availableBills = new TreeMap<>(Comparator.reverseOrder());

    /**
     * bills can be only 5, 10 or 20
     */
    public boolean KvasChange(List<Integer> bills) {
        if (bills.isEmpty())
            return true;
        Integer bill = bills.get(0);
        if (!removeChange(bill)) {
            return false;
        }
        availableBills.merge(bill, 1, (k, v) -> v + 1);
        bills = new ArrayList<>(bills);
        bills.remove(0);
        return KvasChange(bills);
    }

    public boolean removeChange(int bill) {
        if (bill == 5) {
            return true;
        }
        bill -= 5;

        for (Integer key : availableBills.keySet()) {
            while (bill >= key && availableBills.get(key) > 0) {
                availableBills.computeIfPresent(key, (k, v) -> v - 1);
                bill -= key;
            }
            if (bill == 0) {
                return true;
            }
        }
        return false;
    }
}
