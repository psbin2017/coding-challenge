package com.coding.leetcode.problems.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int maxSum = nums[0];

        int startIndex = 0;

        int maxStartIndex = 0;
        int maxEndIndex = 1;

        for ( int i = 1; i < nums.length; i++ ) {
            int target = nums[i];

            // 누계 합보다 이번 값이 더 큰 경우
            // ex) 1 > 1 + -2
            if ( target > target + sum ) {
                // 누계 합을 바꾸고 시작 인덱스를 변경
                sum = target;
                startIndex = i;
            } else {
                sum += target;
            }

            // 최종 합이 더 작은 경우
            if ( sum > maxSum ) {
                maxSum = sum;
                maxStartIndex = startIndex;
                maxEndIndex = i + 1;
            }
        }

        int result = Arrays.stream(nums, maxStartIndex, maxEndIndex)
                            .sum();

        return result;
    }

    @DisplayName("nums = [-2,1,-3,4,-1,2,1,-5,4], output = 6")
    @Test
    public void testMaximumSubarray1() throws Exception {
        // given
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};

        // when
        int actual = maxSubArray(nums);
        int expected = 6;

        // then
        assertEquals(expected, actual);
    }

    @DisplayName("nums = [1], output = 1")
    @Test
    public void testMaximumSubarray2() throws Exception {
        // given
        int[] nums = new int[]{1};

        // when
        int actual = maxSubArray(nums);
        int expected = 1;

        // then
        assertEquals(expected, actual);
    }

    @DisplayName("nums = [5,4,-1,7,8], output = 23")
    @Test
    public void testMaximumSubarray3() throws Exception {
        // given
        int[] nums = new int[]{5,4,-1,7,8};

        // when
        int actual = maxSubArray(nums);
        int expected = 23;

        // then
        assertEquals(expected, actual);
    }
}
