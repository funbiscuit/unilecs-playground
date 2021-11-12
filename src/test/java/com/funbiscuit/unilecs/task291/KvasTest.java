package com.funbiscuit.unilecs.task291;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KvasTest {
    @Test
    void test1() {
        assertTrue(new Kvas().KvasChange(List.of(5, 5, 5, 10, 20)));
        assertFalse(new Kvas().KvasChange(List.of(5, 5, 10, 10, 20)));
    }
}