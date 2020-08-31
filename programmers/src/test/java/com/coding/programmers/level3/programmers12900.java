package com.coding.programmers.level3;

import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12900
 */
public class programmers12900 {
    
    int[] dictionary;
    
    public int solution(int n) {
        dictionary = new int[n];
        int answer = fibo(n);
        return answer;
        // return 1000000007 % answer;
    }

    private int fibo(int value) {
        if ( dictionary[value - 1] == 0 ) {    
            if ( value <= 2 ) {
                dictionary[value - 1] = value;
            } else {
                dictionary[value - 1] = (fibo(value - 1) + fibo(value - 2)) % 1000000007;
            }
        }
        return dictionary[value - 1];
    }

    @Test
    public void test() {
        for (int i = 1; i < 10; i++) {
            System.out.println(
                solution(i)
            );
        }
    }
}