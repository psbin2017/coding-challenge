package com.coding.programmers.level1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12948
 * 핸드폰 번호 가리기
 */
public class programmers12948 {
    public String solution(String phone_number) {
        int size = phone_number.length();
        if ( size > 4 ) {
            StringBuilder sb = new StringBuilder();
            for ( int i = 1; i <= size - 4; i++ ) {
                sb.append("*");
            }
            sb.append( phone_number.substring( size - 4, size ) );
            return sb.toString();
        } else {
            return phone_number;
        }
    }

    @DisplayName("programmers12948")
    @Test
    public void test() {
        System.out.println(solution("01033334444"));
        System.out.println(solution("027778888"));
    }
}