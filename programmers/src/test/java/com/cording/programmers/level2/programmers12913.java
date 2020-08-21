package com.cording.programmers.level2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12913
 */
public class programmers12913 {

    int solution(int[][] land) {
        int length = land.length;
        for (int i = 0; i < length - 1; i++ ) {
            land[i + 1][0] += max(land[i][1], land[i][2], land[i][3], 0);
            land[i + 1][1] += max(land[i][0], land[i][2], land[i][3], 0);
            land[i + 1][2] += max(land[i][0], land[i][1], land[i][3], 0);
            land[i + 1][3] += max(land[i][0], land[i][1], land[i][2], 0);
        }
        return max(land[length - 1][0], land[length - 1][1], land[length - 1][2], land[length - 1][3]);
    }

    int max(int a, int b, int c, int d) {
        return IntStream.of(a, b, c, d).max().getAsInt();
    }

    @Test
    public void test() {
        assertEquals(16, solution(new int[][]{ {1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1} } ));
    }

}