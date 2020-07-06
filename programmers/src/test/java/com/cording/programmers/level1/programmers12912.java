package com.cording.programmers.level1;

import org.junit.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12912
 */
public class programmers12912 {

    public long solution(int a, int b) {
        int last = a > b ? a : b;
        int start = a > b ? b : a;

        long answer = 0;
        for (int i = start; i <= last; i++)  {
            answer += i;
        }
        return answer;
    }

    @Test
    public void test() {
        System.out.println(
            solution( 3, 5 )
        );
        System.out.println(
            solution( 3, 3 )
        );
        System.out.println(
            solution( 5, 3 )
        );
    }
    
}