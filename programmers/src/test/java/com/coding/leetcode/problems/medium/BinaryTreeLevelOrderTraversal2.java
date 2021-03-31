package com.coding.leetcode.problems.medium;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
class BinaryTreeLevelOrderTraversal2 {

    private class TreeNode {
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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        loop(result, 0, root);
        Collections.reverse(result);
        return result;
    }

    private void loop(List<List<Integer>> result, int index, TreeNode node) {
        if ( node == null ) {
            return;
        }
        List<Integer> list;
        try {
            list = result.get(index);
        } catch (IndexOutOfBoundsException e) {
            list = new ArrayList<>();
            result.add(list);
        }
        list.add(node.val);

        int next = index + 1;
        loop(result, next, node.left);
        loop(result, next, node.right);
    }

    @DisplayName("Input: root = [3,9,20,null,null,15,7], Output: [[15,7],[9,20],[3]]")
    @Test
    void test1() throws Exception {
        // given
        TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode left = new TreeNode(9);
        TreeNode root = new TreeNode(3, left, right);

        // when
        List<List<Integer>> result = levelOrderBottom(root);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add( Arrays.asList(15, 7) );
        expected.add( Arrays.asList(9, 20) );
        expected.add( Arrays.asList(3) );

        // then
        assertEquals(expected, result);
    }

    @DisplayName("Input: root = [1], Output: [[1]]")
    @Test
    void test2() throws Exception {
        // given
        TreeNode root = new TreeNode(1);

        // when
        List<List<Integer>> result = levelOrderBottom(root);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add( Arrays.asList(1) );

        // then
        assertEquals(expected, result);
    }

    @DisplayName("Input: root = [], Output: []")
    @Test
    void test3() throws Exception {
        // given

        // when
        List<List<Integer>> result = levelOrderBottom(null);
        List<List<Integer>> expected = new ArrayList<>();

        // then
        assertEquals(expected, result);
    }
    
}