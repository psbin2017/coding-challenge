package com.coding.programmers.level2;

import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12899
 */
public class programmers12899 {
    
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();

        while ( n != 0 ) {
            if ( n % 3 == 0 ) {
                answer.append("4");
                n = n / 3 - 1;
            } else {
                answer.append( n % 3 );
                n = n / 3;
            }
        }

        return answer.reverse().toString();
    }

    @Test
    public void test() {
        for ( int i = 1; i < 10; i++ ) {
            System.out.println( solution(i) );
        }
    }
}