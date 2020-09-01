package com.coding.leetcode.problems.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 */
public class leetcode1047 {
    
    public String removeDuplicates(String S) {

        Deque<String> deque = new ArrayDeque<String>();

        for ( int i = 0; i < S.length(); i++ ) {
            String target = String.valueOf(  S.charAt(i) );
            if ( deque.isEmpty() ) {
                deque.add( target );
                continue;
            }

            if ( deque.getLast().equals( target ) ) {
                deque.pollLast();
            } else {
                deque.add( target );
            }
        }

        StringBuilder sb = new StringBuilder();
        while ( ! deque.isEmpty() ) {
            sb.append( deque.pop() );
        }

        return sb.toString();
    }

    @DisplayName("abbaca")
    @Test
    public void test1() {
        assertEquals(removeDuplicates("abbaca"), "ca");
    }
}