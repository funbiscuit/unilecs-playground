package com.funbiscuit.unilecs.task282;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    /**
     * Node is lonely if it is the only child of its parent
     * root is not lonely since it doesn't have a parent
     * This call treats current node as root node
     *
     * @return list of all lonely nodes
     */
    public List<Integer> getLonelyNodeValues() {
        if (left == null && right == null)
            return Collections.emptyList();

        List<Integer> val = new ArrayList<>();

        if (left == null) {
            val.add(right.val);
        }
        if (right == null) {
            val.add(left.val);
        }
        if (left != null) {
            val.addAll(left.getLonelyNodeValues());
        }
        if (right != null) {
            val.addAll(right.getLonelyNodeValues());
        }
        return val;
    }
}
