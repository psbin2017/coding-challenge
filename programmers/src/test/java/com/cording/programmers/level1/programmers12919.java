package com.cording.programmers.level1;

import org.junit.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12919
 */
public class programmers12919 {
    
    public String solution(String[] seoul) {
        String answer = "김서방은 ";
        for (int i = 0; i < seoul.length; i++) {
            if ( "Kim".equals( seoul[i] ) ) {
                answer += String.valueOf(i) + "에 있다";
                break;
            }
        }
        return answer;
    }

    @Test
    public void test() {
        System.out.println(
            solution(new String[]{"Jane","Kim"})
        );
    }
}