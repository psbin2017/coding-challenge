package com.coding.programmers.level2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42746
 */
public class programmers42746 {
    
    public String solution(int[] numbers) {
        Map<Integer, Integer> multiMap = new HashMap<>();
        for ( int i = 0; i < numbers.length; i++ ) {
            int val = numbers[i];
            if ( val < 10 ) {
                double temp = val * 11111;
                multiMap.put( i , (int) temp );
            } else if ( val >= 10
                && val < 100 ) {
                double temp = val * 1010.1;
                multiMap.put( i , (int) temp );
            } else if ( val >= 100
                && val < 1000 ) {
                double temp = val * 100.1;
                multiMap.put( i , (int) temp );
            } else {
                multiMap.put( i , 10000 );
            }
        }
        
        StringBuilder sb = new StringBuilder();

        multiMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(e -> sb.append( numbers[ e.getKey() ] ) );
        
        if ( sb.toString().startsWith("0") ) {
            return "0";
        }
        return sb.toString();
    }

    // 삽질한 코드
    /*
    public String solution(int[] numbers) {
        Arrays.sort(numbers);

        List<Integer> oneDigits = Arrays.stream(numbers)
                                    .filter(e -> e < 10)
                                    .boxed()
                                    .sorted(Comparator.reverseOrder())
                                    .collect(Collectors.toList());
        List<Integer> tenDigits = Arrays.stream(numbers)
                                    .filter(e -> 10 <= e && e < 100 )
                                    .boxed()
                                    .sorted(Comparator.reverseOrder())
                                    .collect(Collectors.toList());
        List<Integer> hundredDigits = Arrays.stream(numbers)
                                    .filter(e -> 100 <= e && e <= 1000 )
                                    .boxed()
                                    .sorted(Comparator.reverseOrder())
                                    .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        while ( ! oneDigits.isEmpty() ||
                ! tenDigits.isEmpty() ||
                ! hundredDigits.isEmpty() ) {
            
            double one = 0;
            if ( ! oneDigits.isEmpty() ) {
                one = oneDigits.get(0);
            }

            double ten = 0;
            if ( ! tenDigits.isEmpty() ) {
                ten = tenDigits.get(0) / (double) 10;
            }

            double hundred = 0;
            if ( ! hundredDigits.isEmpty() ) {
                if ( hundredDigits.get(0) == 1000 ) {
                    hundred = 1;
                } else {
                    hundred = hundredDigits.get(0) / (double) 100;
                }
            }

            if ( one >= ten &&
                    one >= hundred ) {
                sb.append( oneDigits.get(0) );
                oneDigits.remove(0);
            } else if ( ten >= one &&
                    ten >= hundred ) {
                sb.append( tenDigits.get(0) );
                tenDigits.remove(0);
            } else {
                if ( hundred - one < 1 &&
                        one != 0 ) {
                    sb.append( oneDigits.get(0) );
                    oneDigits.remove(0);
                } else if ( hundred - ten < 1 &&
                        ten != 0 ) {
                    sb.append( tenDigits.get(0) );
                    tenDigits.remove(0);
                } else {
                    sb.append( hundredDigits.get(0) );
                    hundredDigits.remove(0);
                }
            }
        }
        if ( sb.toString().startsWith("0") ) {
            return "0";
        }
        return sb.toString();
    }
    */

    @DisplayName("6, 10, 2")
    @Test
    public void test1() {
        assertEquals( solution(new int[]{6, 10, 2}), "6210" );
    }

    @DisplayName("3, 30, 34, 5, 9")
    @Test
    public void test2() {
        assertEquals( solution(new int[]{3, 30, 34, 5, 9}), "9534330" );
    }

    @DisplayName("40, 403")
    @Test
    public void test3() {
        assertEquals( solution(new int[]{40, 403}), "40403" );
    }

    @DisplayName("0, 0, 0, 0, 0")
    @Test
    public void test4() {
        assertEquals( solution(new int[]{0, 0, 0, 0, 0}), "0" );
    }

    @DisplayName("0, 0, 1000, 0")
    @Test
    public void test5() {
        assertEquals( solution(new int[]{0, 0, 1000, 0}), "1000000" );
    }

    @DisplayName("2, 20, 200")
    @Test
    public void test6() {
        assertEquals( solution(new int[]{2, 20, 200}), "220200" );
    }

    @DisplayName("1, 2, 21, 21")
    @Test
    public void test7() {
        assertEquals( solution(new int[]{1, 2, 21, 21}), "221211" );
    }

    @DisplayName("10, 101")
    @Test
    public void test8() {
        assertEquals( solution(new int[]{10, 101}), "10110" );
    }

}
