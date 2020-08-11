package com.cording.programmers.level2;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 */
public class programmers42584 {
    
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        int last = prices.length - 1;
        for ( int i = 0; i <= last - 1; i++ ) {
            int target = prices[i];

            int time = 0;
            for ( int j = i + 1; j <= last; j++ ) {
                time++;
                if ( target > prices[j] ) {
                    break;
                }
            }
            answer[i] = time;
        }
        answer[last] = 0;
        return answer;
    }

    @Test
    public void test() {
        // System.out.println( Arrays.toString(  solution(new int[]{ 1, 2, 3, 2, 3 }) ) );
        System.out.println( Arrays.toString(  solution(new int[]{ 1, 2, 3, 2, 3, 3, 1 }) ) );
    }

}