package com.coding.programmers.level1;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42862
 */
public class programmers42862 {
    
    public int solution(int n, int[] lost, int[] reserve) {

        Map<Integer, Integer> totalMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            totalMap.put( i + 1, 1 );
        }

        for (int i = 0; i < reserve.length; i++) {
            totalMap.put( reserve[i] , totalMap.get(reserve[i]) + 1 );
        }

        for (int i = 0; i < lost.length; i++ ) {
            totalMap.put( lost[i], totalMap.get(lost[i]) - 1 );
        }

        for (int i : totalMap.keySet() ) {
            if ( totalMap.get(i) == 0 ) {
                int previousIndex = i - 1;
                int nextIndex = i + 1;

                if ( previousIndex > 0 ) {
                    if ( totalMap.get(previousIndex) > 1 ) {
                        totalMap.put( i , 1 );
                        totalMap.put( previousIndex , 1 );
                        continue;
                    }
                }

                if ( nextIndex <= n ) {
                    if ( totalMap.get(nextIndex) > 1 ) {
                        totalMap.put( i , 1 );
                        totalMap.put( nextIndex , 1 );
                        continue;
                    }
                }
            }
        }

        int answer = (int) totalMap.entrySet().stream().filter(x -> x.getValue() >= 1).count();
        return answer;
    }

    @Test
    public void test() {
        System.out.println(
            solution(5, new int[]{2, 4}, new int[]{1, 3, 5})
        );
        System.out.println(
            solution(5, new int[]{2, 4}, new int[]{3})
        );
        System.out.println(
            solution(3, new int[]{3}, new int[]{1})
        );
    }

}