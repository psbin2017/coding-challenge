package com.coding.programmers.level1;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12954
 */
public class programmers12954 {
    
    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        long xLong = Long.valueOf(x);
        long loopValue = xLong;
        for ( int i = 0; i < n; i++) {
            answer[i] = xLong;
            xLong += loopValue;
        }
        return answer;
    }

    @DisplayName("x=2 n=5 answer=[2,4,6,8,10]")
    @Test
    public void test1() {
        int x = 2;
        int n = 5;
        long[] actual = {2, 4, 6, 8, 10};
        assertArrayEquals(solution(x, n), actual);
    }

    @DisplayName("x=4 n=3 answer=[4,8,12]")
    @Test
    public void test2() {
        int x = 4;
        int n = 3;
        long[] actual = {4, 8, 12};
        assertArrayEquals(solution(x, n), actual);
    }

    @DisplayName("x=-4 n=2 answer=[-4,-8]")
    @Test
    public void test3() {
        int x = -4;
        int n = 2;
        long[] actual = {-4, -8};
        assertArrayEquals(solution(x, n), actual);
    }
}
