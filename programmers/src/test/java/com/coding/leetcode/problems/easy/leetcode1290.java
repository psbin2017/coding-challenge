package com.coding.leetcode.problems.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.ToString;

/**
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 */
public class leetcode1290 {
    
    public static int getDecimalValue(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();

        while ( true ) {
            // 앞에서 부터 차례대로 [1,0,1]
            list.add(head.val);
            if ( head.next == null ) {
                break;
            }
            head = head.next;
        }

        int answer = 0;
        int size = list.size() - 1;
        for (int i = 0; i < list.size(); i++ ) {
            if ( list.get(i) == 1 ) {
                // 2 ^ size
                answer += Math.pow( 2 , size );
            }
            size--;
        }

        return answer;
    }

    @DisplayName("5")
    @Test
    public void test1() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(0, a);
        ListNode c = new ListNode(1, b);

        assertEquals( getDecimalValue(c) , 5);
    }

    @DisplayName("18880")
    @Test
    public void test2() {
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(0, a);
        ListNode c = new ListNode(0, b);
        ListNode d = new ListNode(0, c);

        ListNode e = new ListNode(0, d);
        ListNode f = new ListNode(0, e);
        ListNode g = new ListNode(1, f);
        ListNode h = new ListNode(1, g);
        
        ListNode i = new ListNode(1, h);
        ListNode j = new ListNode(0, i);
        ListNode k = new ListNode(0, j);
        ListNode l = new ListNode(1, k);

        ListNode m = new ListNode(0, l);
        ListNode n = new ListNode(0, m);
        ListNode o = new ListNode(1, n);

        assertEquals( getDecimalValue(o) , 18880);
    }

}

@ToString
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}