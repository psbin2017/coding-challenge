package com.coding.programmers.level1;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/68644
 */
public class programmers68644 {
    
    public int[] solution(int[] numbers) {
        int index = 1;
        int numbersLength = numbers.length;
        Set<Integer> setAnswer = new HashSet<>();

        for (int i = 0; i < numbersLength; i++) {
            int leftNumber = numbers[i];

            for (int j = index; j < numbersLength; j++ ) {
                // 같은 인덱스는 스킵한다.
                if ( i == j ) {
                    break;
                }
                int rightNumber = numbers[j];
                setAnswer.add( leftNumber + rightNumber );
            }
        }

        List<Integer> listAnswer = new ArrayList<>(setAnswer);
        Collections.sort(listAnswer);
        Object[] setArray = listAnswer.toArray();

        // Object[] convert int[]
        int arrayLength = setArray.length;
        int[] answer = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++ ) {
            answer[i] = (Integer) setArray[i];
        }
        return answer;
    }

    @DisplayName("number=[2,1,3,4,1], result=[2,3,4,5,6,7]")
    @Test
    public void test1() {
        int[] numbers = {2, 1, 3, 4, 1};
        int[] actual = {2, 3, 4, 5, 6, 7};
        assertArrayEquals(solution(numbers), actual);
    }

    @DisplayName("number=[5,0,2,7], result=[2,5,7,9,12]")
    @Test
    public void test2() {
        int[] numbers = {5, 0, 2, 7};
        int[] actual = {2, 5, 7, 9, 12};
        assertArrayEquals(solution(numbers), actual);
    }
}
