package com.coding.programmers.level2;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42588
 */
public class programmers42588 {
    
    public int[] solution(int[] heights) {
        int length = heights.length;
        int[] answer = new int[heights.length];
        answer[0] = 0;

        for (int i = length - 1; i > 0; i--) {
            int target = heights[i];
            int index = 0;

            for (int j = i - 1; j >= 0; j-- ) {
                if ( heights[j] > target ) { 
                    index = j + 1;
                    break;
                }
            }
            answer[i] = index;
        }

        return answer;
    }

    @Test
    public void test() {
        System.out.println(
            ArrayUtils.toString(
                solution( new int[]{6,9,5,7,4} )
            )
        );
        System.out.println(
            ArrayUtils.toString(
                solution( new int[]{3,9,9,3,5,7,2} )
            )
        );
        System.out.println(
            ArrayUtils.toString(
                solution( new int[]{1,5,3,6,7,6,5} )
            )
        );
        System.out.println(
            ArrayUtils.toString(
                solution( new int[]{5,4,3,2,1} )
            )
        );
    }
}