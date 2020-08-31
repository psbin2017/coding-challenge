package com.coding.programmers.level1;

import java.util.Calendar;
import java.util.Locale;

import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12901
 */
public class programmers12901 {

    public String solution(int a, int b) {
        Calendar cal = Calendar.getInstance();
        cal.set(2016, a - 1, b);
        return cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, /* Locale.getDefault() */ Locale.ENGLISH).substring(0, 3).toUpperCase();
    } 

    @Test
    public void test() {
        solution(5, 24);
    }
}