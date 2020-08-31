package com.coding.programmers.level1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12933
 */
public class programmers12933 {
    
    public long solution(long n) {
        String nToString = Long.toString(n);
        String[] splitString = new String[nToString.length()];
        for (int i=0; i<nToString.length(); i++) {
            splitString[i] = nToString.substring(i, i + 1);
        }
        Arrays.sort(splitString , Collections.reverseOrder());
        return Long.parseLong( String.join("", splitString) );
    }

    @Test
    public void test() {
        assertEquals(873211, solution(118372));
    }
}