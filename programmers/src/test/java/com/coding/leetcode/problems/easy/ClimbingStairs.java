package com.coding.leetcode.problems.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {

    /**
     * 계단을 오르고 있습니다. 정상에 도달하려면 n 단계가 필요합니다.
     *
     * 매번 1 단계 또는 2 단계를 오를 수 있습니다. 얼마나 많은 방법으로 정상에 오를 수 있습니까?
     *
     * ... 경우의 수
     */
    public int climbStairs(int n) {
        int[] memorize = new int[n + 1];
        return climb(n, memorize);
    }

    private int climb(int n, int[] memorize) {
        if ( n <= 2 ) {
            return n;
        } else if ( memorize[n] > 0 ) {
            return memorize[n];
        }
        memorize[n] = climb(n - 1, memorize) + climb( n - 2, memorize);
        return memorize[n];
    }

    @DisplayName("Input: n = 2, Output: 2")
    @Test
    public void testClimbingStairs1() throws Exception {
        // given
        int n = 2;
        
        // when
        int actual = climbStairs(n);
        int expected = 2;
        
        // then
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("Input: n = 3, Output: 3")
    @Test
    public void testClimbingStairs2() throws Exception {
        // given
        int n = 3;

        // when
        int actual = climbStairs(n);
        int expected = 3;

        // then
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("Input: n = 4, Output: 5")
    @Test
    public void testClimbingStairs3() throws Exception {
        // given
        int n = 4;

        // when
        int actual = climbStairs(n);
        int expected = 5;

        // then
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("Input: n = 45, Output: 5")
    @Test
    public void testClimbingStairs4() throws Exception {
        // given
        int n = 45;

        // when
        int actual = climbStairs(n);
        int expected = 1836311903;

        // then
        Assertions.assertEquals(expected, actual);
    }
}
