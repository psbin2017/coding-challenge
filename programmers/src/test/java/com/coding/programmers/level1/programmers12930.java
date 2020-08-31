package com.coding.programmers.level1;

import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12930
 */
public class programmers12930 {
    
    public String solution(String s) {
        s = s.toLowerCase();
        String[] words = s.split(" ", -1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            for (int j = 0; j < word.length(); j++ ) {
                if ( j % 2 == 0 ) {
                    sb.append( Character.toUpperCase( word.charAt(j) ) );
                } else {
                    sb.append( Character.toLowerCase( word.charAt(j) ) );
                }
            }

            if ( i < words.length - 1 ) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(
            solution("try hello world")
        );
    }
}