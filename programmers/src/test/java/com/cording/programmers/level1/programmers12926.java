package com.cording.programmers.level1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12926
 * 시저 암호
 */
public class programmers12926 {

    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder(); 
        for ( int i = 0; i < s.length(); i++ ) {
            char alpha = s.charAt(i);
            if ( alpha != ' ' ) { 
                char location = Character.isLowerCase(alpha) ? 'a' : 'A';
                alpha = (char) (location + (alpha + n - location) % 26);
            }
            answer.append(alpha); 
        } 
        return answer.toString();
    }

    @DisplayName("programmers12926")
    @Test
    public void test() {
        assertEquals("BC", solution("AB", 1));
        assertEquals("a", solution("z", 1));
        assertEquals("e F d", solution("a B z", 4));
    }
}