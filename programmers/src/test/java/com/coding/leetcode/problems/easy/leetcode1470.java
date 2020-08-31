package com.coding.leetcode.problems.easy;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/shuffle-the-array/
 */
public class leetcode1470 {

    public int[] shuffle(int[] nums, int n) {

        int answer[] = new int[nums.length];

        for ( int i = 0; i < n - 1; i++) {
            answer[i * 2] = nums[i];
        }

        int index = 1;
        for ( int j = n; j < nums.length - 1; j++ ) {
            answer[index] = nums[j];
            index += 2;
        }

        return answer;
    }

    @DisplayName("2, 5, 1, 3, 4, 7")
    @Test
    public void test() {
        assertArrayEquals(shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3), new int[]{2, 3, 5, 4, 1, 7});
    }

}