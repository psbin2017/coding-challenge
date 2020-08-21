package com.cording.programmers.level2;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 */
public class programmers42577 {

    public boolean solution(String[] phoneBook) {
        boolean answer = true;
        Arrays.sort(phoneBook, (a, b) -> Integer.compare(a.length(), b.length()) );
        int length = phoneBook.length;
        for (int i = 0; i < length; i++) {
            String phone = phoneBook[i];
            for (int j = i + 1; j < length; j++ ) {
                String comparePhone = phoneBook[j];
                if ( comparePhone.startsWith(phone) ) {
                    answer = false;
                    break;
                }
            }

            if ( ! answer ) {
                break;
            }
        }

        return answer;
    }

    @Test
    public void test() {
        System.out.println( 
            solution(new String[]{ "119", "9764223", "1195524421" }) 
        );
        System.out.println( 
            solution(new String[]{ "123", "456", "789" }) 
        );
        System.out.println( 
            solution(new String[]{ "12", "123", "1235", "567", "88" }) 
        );
        System.out.println( 
            solution(new String[]{ "119", "1192456" }) 
        );
        System.out.println( 
            solution(new String[]{ "1192456", "119" }) 
        );
    }
}