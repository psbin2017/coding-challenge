package com.coding.programmers.level2;

import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/62048
 */
public class programmers62048 {

    public long solution(int w, int h) {
        int split = w + h - gcd(w, h);
        return ( (long) w * (long) h) - split;
    }

    int gcd(int a, int b) {
        while ( b > 0 ) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }

    @Test
    public void test() {
        System.out.println( solution(8, 12) );
    }
}