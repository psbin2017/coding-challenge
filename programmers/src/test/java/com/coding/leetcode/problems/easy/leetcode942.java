package com.coding.leetcode.problems.easy;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/di-string-match/
 */
public class leetcode942 {

    public int[] diStringMatch(String S) {
        int length = S.length();
        int[] answer = new int[length + 1];

        int increase = 0;
        int decrease = length;
        for ( int i = 0; i < length; i++ ) {
            if ( S.charAt(i) == 'I' ) {
                answer[i] = increase;
                increase++;
            } else {
                answer[i] = decrease;
                decrease--;
            }
        }

        answer[length] = increase;
        return answer;
    }

    @DisplayName("IDID")
    @Test
    public void test1() {
        assertArrayEquals(diStringMatch("IDID"), new int[]{0, 4, 1, 3, 2});
    }

}