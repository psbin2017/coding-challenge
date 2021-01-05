package com.coding.programmers.level1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12917
 */
public class programmers12917 {
    
    @DisplayName("Zbcdefg → gfedcbZ")
    @Test
    public void test1() {
        String s = "Zbcdefg";
        String actual = "gfedcbZ";
        assertEquals(solution(s), actual);
    }

    @DisplayName("ZbcdWRWWefag → gfedcbaZWWWR")
    @Test
    public void test2() {
        String s = "ZbcdWRWWefag";
        String actual = "gfedcbaZWWWR";
        assertEquals(solution(s), actual);
    }

    public String solution(String s) {
        int sLength = s.length();
        
        List<String> splitList = new ArrayList<>();
        for ( int i = 0; i < sLength; i++ ) {
            splitList.add( s.substring(i, i + 1) );
        }

        Collections.sort(splitList, Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (String ss : splitList) {
            sb.append(ss);
        }
        return sb.toString();
    }
}
