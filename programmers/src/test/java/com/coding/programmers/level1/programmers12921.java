package com.coding.programmers.level1;

import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12921
 */
public class programmers12921 {
    
    public int solution(int n) {
        int answer = 0;
        int[] number = new int[n+1];
        
        for (int i = 2; i <= n; i++) {
            number[i] = i;
        }

        for (int i = 2; i <= n; i++) {
            if ( number[i] == 0 ) {
                continue;
            } 
            for (int j=  2 * i; j <= n; j = j + i) {
                number[j] = 0;
            }
        }
        
        for (int i = 0; i < number.length; i++) {
            if (number[i] != 0) {
                answer++;
            }
        }
        return answer;
    }

    @Test
    public void test() {
        System.out.println(
            solution(10)
        );
        System.out.println(
            solution(5)
        );
        System.out.println(
            solution(2)
        );
    }
}