package com.coding.programmers.level2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42747
 */
public class programmers42747 {
    
    public int solution(int[] citations) {

        int length = citations.length;
        int answer = 0;

        // 0, 1, 3, 5, 6
        Arrays.sort(citations);

        for ( int i = 0; i < length; i++ ) {
            int quotation = citations[i];
            int size = length - i;
            if ( size <=  quotation ) {
                answer = size;
                break;
            }
        }
        return answer;
    }

    @DisplayName("3, 0, 6, 1, 5")
    @Test
    public void test() {
        assertEquals(solution(new int[]{ 3, 0, 6, 1, 5 }), 3);
    }

    @DisplayName("12, 11, 10, 9, 8, 1")
    @Test
    public void test2() {
        assertEquals(solution(new int[]{ 12, 11, 10, 9, 8, 1 }), 5);
    }

    @DisplayName("6, 6, 6, 6, 6, 1")
    @Test
    public void test3() {
        assertEquals(solution(new int[]{ 6, 6, 6, 6, 6, 1 }), 5);
    }

    @DisplayName("20, 21, 22, 23")
    @Test
    public void test4() {
        assertEquals(solution(new int[]{ 20, 21, 22, 23 }), 4);
    }

    @DisplayName("4, 4, 4")
    @Test
    public void test5() {
        assertEquals(solution(new int[]{ 4, 4, 4 }), 3);
    }

}