package com.coding.leetcode.problems.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {

    private boolean isValid(String s) {
        boolean looper = true;
        while ( looper ) {
            int length = s.length();
            if ( length == 0 ) {
                break;
            }
            s = s.replace("()", "")
                    .replace("[]", "")
                    .replace("{}", "");
            looper = length != s.length();
        }

        return s.length() == 0 ? true : false;
    }

    @DisplayName("() = true")
    @Test
    public void testTrue1() throws Exception {
        // given
        String s = "()";
        
        // when
        boolean actual = isValid(s);

        // then
        assertEquals(true, actual);
    }

    @DisplayName("()[]{} = true")
    @Test
    public void testTrue2() throws Exception {
        // given
        String s = "()[]{}";

        // when
        boolean actual = isValid(s);

        // then
        assertEquals(true, actual);
    }

    @DisplayName("(] = false")
    @Test
    public void testFalse2() throws Exception {
        // given
        String s = "(]";

        // when
        boolean actual = isValid(s);

        // then
        assertEquals(false, actual);
    }
}
