package com.cording.programmers.level1;

import java.util.Arrays;

import org.junit.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12982
 */
public class programmers12982 {
    
    public int solution(int[] d, int budget) {
        Arrays.sort(d);

        int answer = 0;
        for (int i=0; i<d.length; i++ ) {
            if ( budget == 0 ) {
                break;
            } else if ( budget - d[i] >= 0 ) {
                budget -= d[i];
                answer++;
            }
        }
        return answer;
    }

    @Test
    public void test() {
        System.out.println(
            solution(new int[]{1,3,2,5,4}, 9)
        );
        System.out.println(
            solution(new int[]{2,2,3,3}, 10)
        );
    }
    
}