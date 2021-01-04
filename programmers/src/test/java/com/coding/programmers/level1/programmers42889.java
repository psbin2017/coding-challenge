package com.coding.programmers.level1;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42889
 */
public class programmers42889 {
    
    public int[] solution(int N, int[] stages) {

        Map<Integer, Double> stageFailPercentMap = new HashMap<>();
        List<Integer> sortedStages = Arrays.stream(stages).sorted().boxed().collect(Collectors.toList());

        for (int i = 1; i <= N; i++) {
            // final 변수로 접근
            final int targetStage = i;

            long reachStateUserCount = sortedStages.size();
            long notCleardUserCount = (long) sortedStages.stream().filter(o -> o == targetStage).count();
            double failRate;

            // 0 으로 나누면 NaN 으로 정렬 문제 발생
            if ( notCleardUserCount == 0 ) {
                failRate = 0;
            } else {
                failRate = (double) notCleardUserCount / (double) reachStateUserCount;
            }

            // 진행한 루프 스테이지 제거
            sortedStages.removeIf(o -> o == targetStage);

            // 실패율과 루프 스테이지 저장
            stageFailPercentMap.put(targetStage, failRate);
        }

        // 실패율로 재정렬 값이 동일한 스테이지는 스테이지를 우선시한다.
        List<Integer> answer = new ArrayList<>(stageFailPercentMap.keySet());
        Collections.sort(answer, (o1, o2) -> (stageFailPercentMap.get(o2).compareTo(stageFailPercentMap.get(o1))));

        // List<Integer> convert int[]
        Object[] answerObjects = answer.toArray();
        int[] answerArray = new int[answerObjects.length];
        for (int i = 0; i < answerObjects.length; i++) {
            answerArray[i] = (int) answerObjects[i];
        }

        return answerArray;
    }

    @DisplayName("N=5, stages=[2, 1, 2, 6, 2, 4, 3, 3], result=[3, 4, 2, 1, 5]")
    @Test
    public void test1() {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] actual = {3, 4, 2, 1, 5};
        assertArrayEquals(solution(N, stages), actual);
    }

    @DisplayName("N=5, stages=[1, 2, 2, 1, 3], result=[3, 2, 1, 4, 5]")
    @Test
    public void test2() {
        int N = 5;
        int[] stages = {1, 2, 2, 1, 3};
        int[] actual = {3, 2, 1, 4, 5};
        assertArrayEquals(solution(N, stages), actual);
    }

}
