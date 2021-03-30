package com.coding.leetcode.problems.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        loop(root, 0, set);
        return set.size();
    }

    private void loop(TreeNode node, int index, Set<Integer> set) {
        if (node == null) {
            return;
        }

        int next = index + 1;
        set.add(index);
        loop(node.left, next, set);
        loop(node.right, next, set);
    }

    @DisplayName("Input: root = [3,9,20,null,null,15,7], Output: 3")
    @Test
    void test1() throws Exception {
        // given
        TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode left = new TreeNode(9);
        TreeNode root = new TreeNode(3, left, right);

        // when
        int actual = maxDepth(root);
        int expected = 3;

        // then
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("Input: root = [1,null,2], Output: 2")
    @Test
    void test2() throws Exception {
        // given
        TreeNode root = new TreeNode(1, null, new TreeNode(2));

        // when
        int actual = maxDepth(root);
        int expected = 2;

        // then
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("Input: root = [], Output: 0")
    @Test
    void test3() throws Exception {
        // given

        // when
        int actual = maxDepth(null);
        int expected = 0;

        // then
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("Input: root = [0], Output: 1")
    @Test
    void test4() throws Exception {
        // given
        TreeNode root = new TreeNode(0);

        // when
        int actual = maxDepth(root);
        int expected = 1;

        // then
        Assertions.assertEquals(expected, actual);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}