package com.cording.programmers.level2;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 */
public class programmers42586 {
    
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int index = 0;
        int complete = 0;
        
        int size = progresses.length;
        while (true) {
            for (int i = 0; i < size; i++) {
                progresses[i] += speeds[i];
            }

            if ( progresses[index] >= 100 ) {
                complete++;
                for (int i = index + 1; i < size; i++) {
                    if ( progresses[i] < 100 ) {
                        index = i;
                        break;
                    } else {
                        complete++;
                        index++;
                    }
                }
                result.add(complete);
                complete = 0;
            }

            if ( index == size - 1 && progresses[index] >= 100 ) {
                break;
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    @Test
    public void test() {
        assertArrayEquals( 
            new int[]{ 2, 1 }, 
            solution(new int[]{ 93, 30, 55 }, new int[]{ 1, 30, 5 })
        );
        assertArrayEquals(
            new int[]{ 5 },
            solution(new int[]{ 99, 99, 99, 99 ,99 }, new int[]{ 3, 3, 3, 3 ,3 })
        );
        assertArrayEquals(
            new int[]{ 1, 2, 3 },
            solution(new int[]{ 40, 93, 30, 55, 60, 65 }, new int[]{ 60, 1, 30, 5 , 10, 7 })
        );
        assertArrayEquals(
            new int[]{ 2, 4 },
            solution(new int[]{ 93, 30, 55, 60, 40, 65 }, new int[]{ 1, 30, 5 , 10, 60, 7 })
        );
        assertArrayEquals(
            new int[]{ 2 },
            solution(new int[]{ 99, 1 }, new int[]{ 1, 99 })
        );
    }
}