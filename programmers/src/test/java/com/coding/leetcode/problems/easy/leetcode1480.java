package com.coding.leetcode.problems.easy;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/running-sum-of-1d-array/
 */
public class leetcode1480 {
    
    public int[] runningSum(int[] nums) {
        int length = nums.length;
        int[] answer = new int[nums.length];

        int sum = 0;
        for ( int i = 0; i < length; i ++ ) {
            sum += nums[i];
            answer[i] = sum;
        }

        return answer;
    }

    @DisplayName("1, 2, 3, 4")
    @Test
    public void test1() {
        // not assertEquals
        assertArrayEquals(runningSum(new int[]{1, 2, 3, 4}), new int[]{1, 3, 6, 10});
    }

    @DisplayName("1, 1, 1, 1, 1")
    @Test
    public void test2() {
        // not assertEquals
        assertArrayEquals(runningSum(new int[]{1, 1, 1, 1, 1}), new int[]{1, 2, 3, 4, 5});
    }
}