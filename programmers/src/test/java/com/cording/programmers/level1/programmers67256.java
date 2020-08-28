package com.cording.programmers.level1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/67256
 */
public class programmers67256 {

    Map<Integer, int[]> pad = new HashMap<Integer, int[]>(){
        /**
        *
        */
        private static final long serialVersionUID = -5249409987098216136L;

        {
        put(1, new int[]{0, 0}); put(2, new int[]{0, 1}); put(3, new int[]{0, 2}); 
        put(4, new int[]{1, 0}); put(5, new int[]{1, 1}); put(6, new int[]{1, 2}); 
        put(7, new int[]{2, 0}); put(8, new int[]{2, 1}); put(9, new int[]{2, 2}); 
        put(0, new int[]{3, 1}); 
    }};

    Map<String, int[]> hands = new HashMap<String, int[]>(){
        /**
        *
        */
        private static final long serialVersionUID = 2447419084800210219L;

        {
        put("L", new int[]{3, 0}); put("R", new int[]{3, 2}); 
    }};

    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < numbers.length; i++ ) {
            int number = numbers[i];

            int[] pick = pad.get(number);

            if ( pick[1] == 0 ) {
                sb.append("L");
                hands.put("L", pick);
            } else if ( pick[1] == 2 ) {
                sb.append("R");
                hands.put("R", pick);
            } else {
                int[] leftLocation = hands.get("L");
                int[] rightLocation = hands.get("R");

                int leftMove = calcOver(leftLocation, pick);
                int rightMove = calcOver(rightLocation, pick);

                if ( leftMove > rightMove ) {
                    sb.append("R");
                    hands.put("R", pick);
                } else if ( leftMove == rightMove ) {
                    if ( "right".equals(hand) ) {
                        sb.append("R");
                        hands.put("R", pick);
                    } else {
                        sb.append("L");
                        hands.put("L", pick);
                    }
                } else {
                    sb.append("L");
                    hands.put("L", pick);
                }
            }
        }

        return sb.toString();
    }

    public int calcOver(int[] pick, int[] location) {
        int pickX = pick[0];
        int pickY = pick[1];
        int locationX = location[0];
        int locationY = location[1];

        int calOver = 0;
        if ( pickX > locationX ) {
            calOver = pickX - locationX;
        } else {
            calOver = locationX - pickX;
        }

        if ( pickY > locationY ) {
            calOver += pickY - locationY;
        } else {
            calOver += locationY - pickY;
        }

        return calOver;
    }

    @DisplayName("LRLLLRLLRRL")
    @Test
    public void LRLLLRLLRRL() {
        assertEquals(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"), "LRLLLRLLRRL");
    }

    @DisplayName("LRLLRRLLLRR")
    @Test
    public void LRLLRRLLLRR() {
        assertEquals(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"), "LRLLRRLLLRR");
    }

    @DisplayName("LLRLLRLLRL")
    @Test
    public void LLRLLRLLRL() {
        assertEquals(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"), "LLRLLRLLRL");
    }

}