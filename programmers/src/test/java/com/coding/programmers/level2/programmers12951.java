package com.coding.programmers.level2;

import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12951
 */
public class programmers12951 {

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        boolean isPrevBlank = true;
        for ( int i = 0; i < s.length(); i++ ) {
            char c = s.charAt(i);
            if ( c == ' ' ) {
                isPrevBlank = true;
                sb.append(c);
            } else if ( c != ' ' && isPrevBlank == false ) {
                String a = Character.toString(c).toLowerCase();
                sb.append(a);
            } else {
                String a = Character.toString(c).toUpperCase();
                isPrevBlank = false;
                sb.append(a);
            }
        }
        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println( "'" + solution("3people unFollowed me") + "'" );
        System.out.println( "'" + solution("for the last week") + "'" );
        System.out.println( "'" + solution("for      the last week") + "'" );
        System.out.println( "'" + solution("for the last week          ") + "'" );
        System.out.println( "'" + solution("          for the last week") + "'" );
    }

}