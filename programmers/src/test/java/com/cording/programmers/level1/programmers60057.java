package com.cording.programmers.level1;

import org.junit.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/60057
 */
public class programmers60057 {
    
    public int solution(String s) {
        int sLength = s.length();
        int answer = sLength;
        for (int i = 1; i <= sLength / 2; i++)  {
            int compressSize = doCompress(i, s);
            if ( compressSize < answer ) {
                answer = compressSize;
            }
        }
        return answer;
    }

    private int doCompress(int index, String string) {
        int lastIndex =  string.length();
        int lastArray = 0;
        if ( lastIndex % index != 0 ) {
            lastArray = 1;
        }

        // step 01. 배열 초기화
        String[] substringArrays = new String[ (lastIndex / index + lastArray) ];
        
        // step 02. 배열 나누기
        int startIndex = 0;
        int arrayPointer = 0;
        while ( startIndex < lastIndex ) {
            int endIndex = startIndex + index;
            if ( endIndex > lastIndex ) {
                endIndex = lastIndex;
            }

            substringArrays[arrayPointer] = string.substring(startIndex, endIndex);

            arrayPointer++;
            startIndex += index;
        }

        // step 03. 첫 패턴 초기화
        String pattern = substringArrays[0];
        int counter =  0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < substringArrays.length; i++) {

            /** 패턴과 문자열이 일치하는 경우 카운터 증가 */
            if ( pattern.equals( substringArrays[i] ) ) {
                counter++;

            /** 패턴과 문자열이 다른 경우 문자열로 붙임 */
            } else {
                if ( counter > 1 ) {
                    sb.append( counter + pattern );
                } else {
                    sb.append( pattern );
                }
                /** i 패턴 초기화 */
                counter = 1;
                pattern = substringArrays[i];
            }

        }

        if ( counter > 1 ) {
            sb.append( counter + pattern );
        } else {
            sb.append( pattern );
        }
        return sb.length();
    }

    @Test
    public void test() {
        System.out.println(
            solution("aabbaccc") // 8 자리
        );
        System.out.println(
            solution("ababcdcdababcdcd") // 16 자리
        );
        System.out.println(
            solution("abcabcdede") // 10 자리
        );
        System.out.println(
            solution("abcabcabcabcdededededede") // 24 자리
        );
        System.out.println(
            solution("xababcdcdababcdcd") // 17 자리
        );
    }
}