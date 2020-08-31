package com.coding.programmers.level2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 */
public class programmers42583 {
    
    public int solution(final int bridgeLength, final int weight, final int[] truckWeights) {
        int answer = 0;
        Deque<Map<Integer, Integer>> bridge = new ArrayDeque<Map<Integer, Integer>>();

        int index = 0;
        while (true) {

            answer++;

            // 2-1. 다리가 비어있으면 트럭 추가 (모든 트럭의 무게는 1 이상 weight 이하)
            if ( bridge.isEmpty() && truckWeights.length > index ) {
                Map<Integer, Integer> truck = new HashMap<Integer, Integer>();
                truck.put(1, truckWeights[index]);
                bridge.add(truck);
                index++;
            } else {
                // 2-2. 다리에 있는 트럭 무게 합계 (단, 첫번째가 도달시 무게에서 제외)
                int currentWeight = 0;
                boolean isHeadFinish = false;
                for ( Iterator<Map<Integer, Integer>> iter = bridge.iterator(); iter.hasNext(); ) {
                    Map<Integer, Integer> truck = iter.next();
                    for ( int key : truck.keySet() ) {
                        int truckWeight = truck.get(key);
                        truck.remove(key);
                        truck.put(key + 1, truckWeight);
                        if ( ! isHeadFinish && key + 1 > bridgeLength ) {
                            isHeadFinish = true;
                        } else {
                            currentWeight += truckWeight;
                        }
                    }
                }

                // 2-3. 도착한 경우 제거대상
                if ( isHeadFinish ) {
                    bridge.pollFirst().toString();
                }

                // 2-4. 추가해도 무게가 넘지 않는 경우와 다리가 꽉차지 않은 경우 트럭 추가
                if ( bridge.size() < weight && truckWeights.length > index && weight >= currentWeight + truckWeights[index] ) {
                    Map<Integer, Integer> truck = new HashMap<Integer, Integer>();
                    truck.put(1, truckWeights[index]);
                    bridge.add(truck);
                    index++;
                }
            }

            // 다리를 모두 건넜으면 종료
            if ( truckWeights.length == index && bridge.isEmpty() ) {
                break;
            }
        }

        return answer;
    }

    @Test
    public void test() {
        System.out.println(
            solution(2, 10, new int[]{ 7, 4, 5, 6 })
        );
        System.out.println(
            solution(100, 100, new int[]{ 10 })
        );
        System.out.println(
            solution(100, 100, new int[]{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 })
        );
    }
}