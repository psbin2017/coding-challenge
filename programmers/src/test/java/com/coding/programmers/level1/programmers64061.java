package com.coding.programmers.level1;

import java.util.Stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12901
 */
public class programmers64061 {
    
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> basket = new Stack<>();

        for ( int i = 0; i < moves.length; i++ ) {
            int craneLocation = moves[i] - 1;

            // 크레인 위치에서 인형을 찾는다.
            for ( int j = 0; j < board.length; j++ ) {
                int doll = board[ j ][ craneLocation ];

                // 인형을 찾음
                if ( doll != 0 ) {
                    board[ j ][ craneLocation ] = 0;
                    if ( isPop(basket, doll) ) {
                        answer++;
                    }
                    break;
                }
            }
        }
        return answer * 2;
    }

    private boolean isPop(Stack<Integer> basket, int doll) {
        // case 01. 바구니가 비어있는 경우
        if ( basket.isEmpty() ) {
            basket.add(doll);
            return false;
        // case 02. 마지막 인형과 가져온 인형이 일치하는 경우
        } else if ( basket.peek() == doll ) {
            basket.pop();
            return true;
        }
        basket.add(doll);
        return false;
    }

    @DisplayName("크레인 인형뽑기 게임 예제")
    @Test
    public void test1() {
        int[][] board = { 
            { 0, 0, 0, 0, 0 }
            , { 0, 0, 1, 0, 3 }
            , { 0, 2, 5, 0, 1 }
            , { 4, 2, 4, 4, 2 }
            , { 3, 5, 1, 3, 1 } 
        };
        int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
        solution(board, moves);
    }
}
