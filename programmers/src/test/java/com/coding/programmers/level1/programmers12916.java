package com.coding.programmers.level1;

import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12916
 */
public class programmers12916 {
    
    boolean solution(String s) {
        s = s.toUpperCase();
        boolean answer = true;

        int yCounter = 0;
        int pCounter = 0;
        for (int i=0; i<s.length(); i++) {
            String charAt = Character.toString( s.charAt(i) );
            if ( "P".equals( charAt ) ) {
                pCounter++;
            } else if ( "Y".equals( charAt ) ) {
                yCounter++;
            }
        }

        if ( yCounter != pCounter ) {
            answer = false;
        }

        return answer;
    }

    @Test
    public void test() {
        System.out.println(
            solution("pPoooyY")
        );
        System.out.println(
            solution("Pyy")
        );
    }
}