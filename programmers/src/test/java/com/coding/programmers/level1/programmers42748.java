package com.coding.programmers.level1;

import java.util.Arrays;
import org.junit.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42748
 */
public class programmers42748 {
    
    public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[ commands.length ];
        for ( int i = 0; i < commands.length ; i++ ) {
            int startLength = commands[i][0] - 1;
            int endLength = commands[i][1];
            int target = commands[i][2] - 1;
            int size = endLength - startLength;

            if ( target > size ) {
                target = size;
            }

            int[] splitArray = new int[size];
            int index = 0;
            for (int j = startLength; j < endLength; j++) {
                splitArray[index] = array[j];
                index++;
            }
            
            Arrays.sort(splitArray);
            answer[i] = splitArray[target];
        }
        return answer;
    }

    @Test
    public void test() {
        System.out.println(
            Arrays.toString(
                solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}} )
            )        
        );
    }

}