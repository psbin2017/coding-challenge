package com.coding.programmers.level1;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12906
 */
public class programmers12906 {
    
    public int[] solution(int[] arr) {
        
        List<Integer> list = new ArrayList<>();
        int cache = -1;
        for (int i = 0; i < arr.length; i++) {
            if ( cache != arr[i] ) {
                cache = arr[i];
                list.add(cache);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
	}

    @Test
    public void test() {
        System.out.println(
            ArrayUtils.toString(
                solution( new int[]{1,1,3,3,0,1,1} )
            )
        );
        System.out.println(
            ArrayUtils.toString(
                solution( new int[]{4,4,4,3,3} )
            )
        );
    }

}