package com.coding.leetcode.problems.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

    @DisplayName("nums = [2,7,11,15], target = 9")
    @Test
    public void testTarget9_output0And1() throws Exception {
        // given
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        // when
        int[] actual = twoSum(nums, target);
        int[] expected = new int[]{0, 1};
                
        // then
        assertArrayEquals(expected, actual);
    }

    @DisplayName("nums = [3,2,4], target = 6")
    @Test
    public void testTarget6_output1And2() throws Exception {
        // given
        int[] nums = new int[]{3, 2, 4};
        int target = 6;
        
        // when
        int[] actual = twoSum(nums, target);
        int[] expected = new int[]{1, 2};
        
        // then
        assertArrayEquals(expected, actual);
    }

    @DisplayName("nums = [3,3], target = 6")
    @Test
    public void testTarget6_output0And1_sameNumber() throws Exception {
        // given
        int[] nums = new int[]{3, 3};
        int target = 6;

        // when
        int[] actual = twoSum(nums, target);
        int[] expected = new int[]{0, 1};

        // then
        assertArrayEquals(expected, actual);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        // 조건: 답은 반드시 있으며 하나만 존재한다.
        boolean flag = false;
        for ( int i = 0; i < nums.length; i++ ) {
            for ( int j = i + 1; j < nums.length; j++ ) {
                if ( nums[i] + nums[j] == target ) {
                    result[0] = i;
                    result[1] = j;
                    flag = true;
                    break;
                }
            }

            if ( flag ) {
                break;
            }
        }

        return result;
    }

}
