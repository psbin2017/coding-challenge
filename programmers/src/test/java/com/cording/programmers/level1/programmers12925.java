package com.cording.programmers.level1;

import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12925
 */
public class programmers12925 {
    
    public int solution(String s) {
        return Integer.parseInt(s);
    }

    @Test
    public void test() {
        System.out.println( solution("+1234") );
        System.out.println( solution("-1234") );
    }

}