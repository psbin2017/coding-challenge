package com.coding.leetcode.problems.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 */
public class leetcode1342 {
    
    public int numberOfSteps (int num) {
        int answer = 0;
        
        while ( num > 0 ) {
            if ( num % 2 == 0 ) {
                num /= 2;
            } else {
                num -= 1;
            }
            answer++;
        }

        return answer;
    }

    @DisplayName("14 to 6")
    @Test
    public void test() {
        assertEquals(14, 6);
    }

}