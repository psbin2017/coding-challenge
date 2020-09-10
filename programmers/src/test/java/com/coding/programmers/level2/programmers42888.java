package com.coding.programmers.level2;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42888
 */
public class programmers42888 {
    
    private final String ENTER = "Enter";
    private final String LEAVE = "Leave";
    // private final String CHANGE = "Change";

    public String[] solution(String[] record) {
        int length = record.length;
        List<String> answer = new ArrayList<>();

        Map<String, String> userList = new HashMap<>();
        for ( int i = 0 ; i < length; i++ ) {
            String[] messages = record[i].split("\\s+");

            // skip Leave
            String command = messages[0];
            if ( LEAVE.equals(command) ) {
                continue;
            }

            userList.put(messages[1], messages[2]);
        }

        for ( int i = 0 ; i < length; i++ ) {
            String[] messages = record[i].split("\\s+");

            String command = messages[0];
            if ( ENTER.equals( command ) ) {
                answer.add( userList.get( messages[1] ).toString() + "님이 들어왔습니다." );
            } else if ( LEAVE.equals( command ) ) {
                answer.add( userList.get( messages[1] ).toString() + "님이 나갔습니다." );
            }
        }

        return answer.toArray(new String[answer.size()]);
    }

    @DisplayName("[\"Enter uid1234 Muzi\", \"Enter uid4567 Prodo\",\"Leave uid1234\",\"Enter uid1234 Prodo\",\"Change uid4567 Ryan\"]")
    @Test
    public void test1() {
        assertArrayEquals(
            solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"})
            ,
            new String[]{"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."}
        );
    }

}