package com.coding.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42840
 */
public class programmers42840 {
    
    public int[] solution(int[] answers) {

        final int[] onePattern = new int[]{1,2,3,4,5};
        final int[] twoPattern = new int[]{2,1,2,3,2,4,2,5};
        final int[] threePattern = new int[]{3,3,1,1,2,2,4,4,5,5};

        int oneAnswer = 0;
        int twoAnswer = 0;
        int threeAnswer = 0;

        for (int i = 0; i < answers.length; i++) {
            int oneIndex = i % onePattern.length;
            int twoIndex = i % twoPattern.length;
            int threeIndex = i % threePattern.length;
            int answer = answers[i];

            if ( answer == onePattern[oneIndex] ) {
                oneAnswer++;
            }
            if ( answer == twoPattern[twoIndex] ) {
                twoAnswer++;
            }
            if ( answer == threePattern[threeIndex] ) {
                threeAnswer++;
            }
        }

        boolean oneResult = isResult(oneAnswer, twoAnswer, threeAnswer);
        boolean twoResult = isResult(twoAnswer, oneAnswer, threeAnswer);
        boolean threeResult = isResult(threeAnswer, oneAnswer, twoAnswer);

        List<Integer> list = new ArrayList<>();

        if ( oneResult ) {
            list.add(1);
        }
        if ( twoResult ) {
            list.add(2);
        }
        if ( threeResult ) {
            list.add(3);
        }

        int[] result = new int[list.size()];
        for (int i=0; i<result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private boolean isResult(int target, int oneCompare, int twoCompare) {
        if ( target >= oneCompare && target >= twoCompare ) {
            return true;
        }
        return false;
    }


    @Test
    public void test() {
        System.out.println(
            Arrays.toString(
                solution(new int[]{1,2,3,4,5})
            )
        );

        System.out.println(
            Arrays.toString(
                solution(new int[]{1,3,2,4,2})
            )
        );
    }
}