package com.cording.programmers.level1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12918
 * 문자열 다루기 기본
 */
public class programmers12918 {
    
    public boolean solution(String s) {
        if ( s.length() == 4 || s.length() == 6  ) {
            try {
                Integer.parseInt(s);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        } else {
            return false;
        }
    }

    @DisplayName("programmers12918")
    @Test
    public void test() {
        assertEquals(false, solution("a234"));
        assertEquals(true, solution("1234"));
        assertEquals(false, solution("1"));
        assertEquals(false, solution("12345678"));
    }
}