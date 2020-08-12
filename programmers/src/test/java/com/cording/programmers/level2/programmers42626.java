package com.cording.programmers.level2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 */
public class programmers42626 {
    
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        // K 보다 작은 대상이 없는 경우 섞을 필요가 없다.
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>( Arrays.stream(scoville).filter(i -> i < K).boxed().collect(Collectors.toList()) );
        if ( priorityQueue.size() < 2 ) {
            return answer;
        }
        while ( true ) {
            // 섞어 놓은게 K 보다 큰 경우
            int firstScoville = priorityQueue.poll();
            if ( firstScoville >= K ) {
                break;
            // 마지막까지 다 섞었는데 K 보다 작은 경우
            } else if ( priorityQueue.isEmpty() ) {
                answer = -1;
                break;
            }
            int secondScoville = priorityQueue.poll();

            // 섞고 재정렬
            answer++;
            priorityQueue.add( firstScoville + ( secondScoville * 2 ) );
        }
        return answer;
    }

    @Test
    public void test() {
        System.out.println( solution(new int[]{1, 2, 3, 9, 10, 12}, 7) );
    }
}