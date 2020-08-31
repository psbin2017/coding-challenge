package com.coding.programmers.level2;

import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/49993
 */
public class programmers49993 {
    
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (int i = 0; i < skill_trees.length; i++) {
            int skillIndex = 0;
            boolean flag = true;
            
            for (int j = 0; j < skill_trees[i].length(); j++) {

                for (int k = skillIndex; k < skill.length(); k++) {

                    if ( skill.charAt(k) == skill_trees[i].charAt(j) ) {
                        if ( k != skillIndex ) {
                            flag = false;
                        } else {
                            skillIndex++;
                        }
                    }

                }
            }
            
            if ( flag == true ) {
                answer ++;
            }
        }

        return answer;
    }
    
    @Test
    public void test() {
        System.out.println(
            solution("CBD", new String[]{ "BACDE", "CBADF", "AECB", "BDA", "AQWER" })
        );
    }
}