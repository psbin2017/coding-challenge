package com.cording.programmers.level2;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42578
 */
public class programmers42578 {

    public int solution(String[][] clothes) {
        Map<String, Integer> partition = new HashMap<String, Integer>();
        
        for ( int i = 0; i < clothes.length; i++ ) {
            String parts = clothes[i][1];
            if ( partition.containsKey( parts ) ) {
                partition.put( parts , partition.get( parts ) + 1 );
            } else {
                partition.put( parts , 1 );
            }
        }

        int result = 1;
        for ( String key : partition.keySet() ) {
            // 각 각의 경우의 수를 곱한다. 이 때, 입지 않는 경우를 더하여 + 1
            result = ( partition.get(key) + 1 ) * result;
        }
        // 마지막으로 모두 입지 않은 경우의 수를 뺀다.
        return result - 1;
    }

    @Test
    public void test() {
        System.out.println(
            solution(new String[][]{ {"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"} })
        );
        System.out.println(
            solution(new String[][]{ {"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"} })
        );
        System.out.println(
            solution(new String[][]{ {"똥그란 안경", "얼굴"}, {"깜장 썬글라스", "얼굴"}, {"퍼렁 티셔츠", "상의"}, {"찢어진 청바지", "하의"}, {"버버리 코트", "겉옷"} })
        );
    }
}