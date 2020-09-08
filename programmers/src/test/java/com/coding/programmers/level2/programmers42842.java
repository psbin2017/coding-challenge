package com.coding.programmers.level2;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42842
 */
public class programmers42842 {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int volume = 1;

        while ( true ) {
            if ( yellow % volume != 0 ) {
                volume++;
                continue;
            }
            
            int upDownVolume = (yellow / volume) * 2;
            int leftRightVolume = (volume * 2) + 4;

            if ( upDownVolume + leftRightVolume == brown ) {
                answer[0] = (yellow / volume) + 2;
                answer[1] = volume + 2;
                break;
            } else {
                volume++;
            }
        }

        return answer;
    }

    @DisplayName("(10, 2)")
    @Test
    public void test1() {
        assertArrayEquals(solution(10, 2), new int[]{4, 3});
    }

    @DisplayName("(8, 1)")
    @Test
    public void test2() {
        assertArrayEquals(solution(8, 1), new int[]{3, 3});
    }

    @DisplayName("(24, 24)")
    @Test
    public void test3() {
        assertArrayEquals(solution(24, 24), new int[]{8, 6});
    }

}