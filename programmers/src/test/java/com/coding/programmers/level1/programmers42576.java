package com.coding.programmers.level1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 */
public class programmers42576 {
    
    public String solution(String[] participant, String[] completion) {
        List<String> participantList = Arrays.asList(participant);
        List<String> completionList = Arrays.asList(completion);
        
        participantList.sort(Comparator.naturalOrder());
        completionList.sort(Comparator.naturalOrder());

        String one = participantList.get( participantList.size() - 1 );
        for (int i = 0; i < participantList.size() - 1; i++) {
            if ( ! participantList.get(i).equals( completionList.get(i) ) ) {
                one = participantList.get(i);
                break;
            }
        }

        return one;
    }

    @Test
    public void test() {
        System.out.println(
            solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"})
        );

        System.out.println(
            solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"})
        );

        System.out.println(
            solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"})
        );
    }
}