package com.coding.programmers.level1;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12969
 */
public class programmers12969 {
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            String map1 = Integer.toBinaryString( arr1[i] );
            String map2 = Integer.toBinaryString( arr2[i] );

            int isZeroAppend = n - map1.length();
            if ( isZeroAppend > 0 ) {
                map1 = appendZero(isZeroAppend, map1);
            }
            isZeroAppend = n - map2.length();
            if ( isZeroAppend > 0 ) {
                map2 = appendZero(isZeroAppend, map2);
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++ ) {
                String map1Char = String.valueOf( map1.charAt(j) );
                String map2Char = String.valueOf( map2.charAt(j) );
                
                if ( "1".equals(map1Char) || "1".equals(map2Char) ) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }

    private String appendZero(int count, String before) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("0");
        }
        sb.append(before);
        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(
            ArrayUtils.toString(
                solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})
            )
        );
        System.out.println(
            ArrayUtils.toString(
                solution(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10})
            )
        );
    }
}