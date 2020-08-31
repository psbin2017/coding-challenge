package com.coding.programmers.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12910
 */
public class programmers12910 {
    
    public int[] solution(int[] arr, int divisor) {

        List<Integer> arrList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if ( arr[i] % divisor == 0 ) {
                arrList.add(arr[i]);
            }
        }

        if ( arrList.isEmpty() ) {
            return new int[]{-1};
        }

        int size = arrList.size();
        Collections.sort(arrList);
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i] = arrList.get(i);
        }
        return answer;
    }

    @Test
    public void test() {
        System.out.println(
            ArrayUtils.toString(
                solution(new int[]{5, 9, 7, 10}, 5)
            )
        );
        System.out.println(
            ArrayUtils.toString(
                solution(new int[]{2, 36, 1, 3}, 1)
            )
        );
        System.out.println(
            ArrayUtils.toString(
                solution(new int[]{3,2,6}, 5)
            )
        );
    }
}