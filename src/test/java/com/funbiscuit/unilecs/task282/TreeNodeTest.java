package com.funbiscuit.unilecs.task282;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TreeNodeTest {
    @Test
    void tree1() {
        TreeNode n2 = new TreeNode(2, null, null);
        TreeNode n5 = new TreeNode(5, null, null);
        TreeNode n11 = new TreeNode(11, null, null);
        TreeNode n4 = new TreeNode(4, null, null);
        TreeNode n6 = new TreeNode(6, n5, n11);
        TreeNode n9 = new TreeNode(9, null, n4);
        TreeNode n55 = new TreeNode(55, null, n9);
        TreeNode n7 = new TreeNode(7, n2, n6);
        TreeNode n22 = new TreeNode(22, n7, n55);

        List<Integer> values = n22.getLonelyNodeValues();
        values.sort(Comparator.naturalOrder());
        assertIterableEquals(List.of(4, 9), values);
    }

    @Test
    void emptyTree() {
        TreeNode root = new TreeNode(2, null, null);

        List<Integer> values = root.getLonelyNodeValues();
        assertTrue(values.isEmpty());
    }
}