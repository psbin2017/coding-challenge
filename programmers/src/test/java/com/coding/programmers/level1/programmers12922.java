package com.coding.programmers.level1;

import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12922
 */
public class programmers12922 {
    
    public String solution(int n) {
        final String SU = "수";
        final String BAK = "박";

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if ( i % 2 == 1 ) {
                sb.append(SU);
            } else {
                sb.append(BAK);
            }
        }

        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(
            solution( 3 )
        );
        System.out.println(
            solution( 4 )
        );
    }
}