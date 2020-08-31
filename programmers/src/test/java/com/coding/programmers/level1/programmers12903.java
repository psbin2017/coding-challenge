package com.coding.programmers.level1;

import org.junit.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12903
 */
public class programmers12903 {
    
    public String solution(String s) {
        int middle = s.length() / 2;

        if ( s.length() % 2 == 0) {
            return s.substring(middle - 1, middle + 1);
        } else {
            return s.substring(middle, middle + 1);
        }
    }

    @Test
    public void test() {
        System.out.println(
            solution("abcde")
        );

        System.out.println(
            solution("qwer")
        );
    }
}