package com.cording.programmers.level1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12944
 * 평균 구하기
 */
public class programmers12944 {
    
    public double solution(int[] arr) {
        return Arrays.stream(arr).average().getAsDouble();
    }

    @DisplayName("programmers12944")
    @Test
    public void test() {
        assertEquals( 2.5 , solution(new int[]{1, 2, 3, 4}) );
        assertEquals( 5 , solution(new int[]{5, 5}) );
    }
}