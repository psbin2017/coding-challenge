package com.coding.programmers.level2;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42885
 */
public class programmers42885 {
    
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
 
        int answer = 0;
        int index = people.length - 1;
        for (int i = 0; i <= index; i++, answer++)  {
            while ( index > i && people[i] + people[index--] > limit )  {
                answer++;
            }
        }
 
        return answer;
    }

    @Test
    public void test() {
        System.out.println( solution(new int[]{ 70, 50, 80, 50 }, 100) );
        System.out.println( solution(new int[]{ 70, 80, 50 }, 100) );
    }

}