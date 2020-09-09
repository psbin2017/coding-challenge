package com.coding.programmers.level2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42587
 */
public class programmers42587 {
    
    public int solution(int[] priorities, int location) {
        int length = priorities.length;

        Deque<Map<Integer, Integer>> locationDeque = new ArrayDeque<>();
        Map<Integer, Integer> priorityCounter = new HashMap<>();
        int maxPriority = -1;

        for ( int i = 0; i < length; i++ ) {
            int targetPriority = priorities[i];

            // 각 우선순위 개수 저장
            if ( priorityCounter.containsKey(targetPriority) ) {
                priorityCounter.put( targetPriority , priorityCounter.get(targetPriority) + 1 );
            } else {
                priorityCounter.put( targetPriority , 1 );
            }

            // 최대 우선 순위 저장
            if ( maxPriority < targetPriority ) {
                maxPriority = targetPriority;
            }

            // 값과 이전 인덱스를 저장
            Map<Integer, Integer> map = new HashMap<>();
            map.put( targetPriority , i );
            locationDeque.add( map );
        }

        List<Map<Integer, Integer>> result = new ArrayList<>();
        while ( result.size() != length ) {

            // 우선순위 값이 없으면 스킵
            if ( ! priorityCounter.containsKey( maxPriority ) ) {
                maxPriority--;
                continue;
            }

            for ( int i = 0; i < locationDeque.size(); i++ ) {
                Map<Integer, Integer> map = locationDeque.pollFirst();
                if ( map.containsKey(maxPriority) ) {
                    priorityCounter.put( maxPriority , priorityCounter.get(maxPriority) - 1 );
                    result.add(map);
                } else {
                    locationDeque.addLast(map);
                }

                // 같은 숫자로 우선순위 값이 없으면 뒤 스킵
                if ( priorityCounter.get( maxPriority ) == 0 ) {
                    maxPriority--;
                    break;
                }
            }
        }

        int answer = -1;
        for ( int i = 0; i < result.size(); i++ ) {
            Map<Integer,Integer> map = result.get(i);
            boolean isAnswer = false;

            for ( int key : map.keySet() ) {
                if ( location == map.get(key) ) {
                    isAnswer = true;
                    break;
                }
            }

            if ( isAnswer ) {
                answer = i + 1;
                break;
            }
        }

        return answer;
    }

    @DisplayName("2, 1, 3, 2")
    @Test
    public void test1() {
        assertEquals(solution( new int[]{2, 1, 3, 2} , 2 ), 1);
    }

    @DisplayName("1, 1, 9, 1, 1, 1")
    @Test
    public void test2() {
        assertEquals(solution( new int[]{1, 1, 9, 1, 1, 1} , 0 ), 5);
    }
}