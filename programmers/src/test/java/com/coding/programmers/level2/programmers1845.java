package com.coding.programmers.level2;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/1845
 */
public class programmers1845 {

    public int solution(int[] nums) {
        int answer = nums.length / 2;
        int[] uniqueNums = IntStream.of(nums).distinct().toArray();
        if ( answer < uniqueNums.length ) {
            return answer;
        }
        return uniqueNums.length;
    }

    @Test
    public void test() {
        System.out.println(
            solution(new int[]{3,1,2,3})
        );
        System.out.println(
            solution(new int[]{3,3,3,2,2,4})
        );
        System.out.println(
            solution(new int[]{3,3,3,2,2,2})
        );
    }
}