package com.coding.programmers.level1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12935
 */
public class programmers12935 {
    
    public int[] solution(int[] arr) {
        if ( arr.length == 1 ) {
            return new int[] {-1};
        }

        List<Integer> lists = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int min = Collections.min(lists);
        int index = lists.indexOf(min);
        lists.remove(index);

        int[] answer = new int[lists.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = lists.get(i);
        }

        return answer;
    }

    @Test
    public void test() {
        System.out.println(
            Arrays.toString(
                solution(new int[]{1,3,7,5,11,99,33,22})
            )
        );

        System.out.println(
            Arrays.toString(
                solution(new int[]{10})
            )
        );

        System.out.println(
            Arrays.toString(
                solution(new int[]{4,3,2,1})
            )
        );
    }

}