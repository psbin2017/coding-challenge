package com.coding.leetcode.problems.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/plus-one/
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int length = digits.length;

        if ( digits[length - 1] + 1 < 10 ) {
            digits[length - 1] = digits[length - 1] + 1;
            return digits;
        }

        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < length; i++) {
            sb.append(digits[i]);
        }

        BigInteger plusOne = new BigInteger(sb.toString())
                                        .add(new BigInteger(String.valueOf(1)));

        return Stream.of(String.valueOf(plusOne)
                    .split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
    }

    @DisplayName("digits = [1,2,3], output = [1,2,4]")
    @Test
    public void testPlusOne1() throws Exception {
        // given
        int digit[] = new int[]{1,2,3};

        // when
        int[] actual = plusOne(digit);
        int[] expected = new int[]{1,2,4};

        // then
        Assertions.assertArrayEquals(expected, actual);
    }

    @DisplayName("digits = [4,3,2,1], output = [4,3,2,2]")
    @Test
    public void testPlusOne2() throws Exception {
        // given
        int digit[] = new int[]{4,3,2,1};

        // when
        int[] actual = plusOne(digit);
        int[] expected = new int[]{4,3,2,2};

        // then
        Assertions.assertArrayEquals(expected, actual);
    }

    @DisplayName("digits = [0], output = [1]")
    @Test
    public void testPlusOne3() throws Exception {
        // given
        int digit[] = new int[]{0};

        // when
        int[] actual = plusOne(digit);
        int[] expected = new int[]{1};

        // then
        Assertions.assertArrayEquals(expected, actual);
    }

    @DisplayName("digits = [9], output = [1, 0]")
    @Test
    public void testPlusOne4() throws Exception {
        // given
        int digit[] = new int[]{9};

        // when
        int[] actual = plusOne(digit);
        int[] expected = new int[]{1, 0};

        // then
        Assertions.assertArrayEquals(expected, actual);
    }

    @DisplayName("digits = [9, 9], output = [1, 0, 0]")
    @Test
    public void testPlusOne5() throws Exception {
        // given
        int digit[] = new int[]{9, 9};

        // when
        int[] actual = plusOne(digit);
        int[] expected = new int[]{1, 0, 0};

        // then
        Assertions.assertArrayEquals(expected, actual);
    }

    @DisplayName("digits = [5,6,2,0,0,4,6,2,4,9], output = [5,6,2,0,0,4,6,2,5,0]")
    @Test
    public void testPlusOne6() throws Exception {
        // given
        int digit[] = new int[]{5,6,2,0,0,4,6,2,4,9};

        // when
        int[] actual = plusOne(digit);
        int[] expected = new int[]{5,6,2,0,0,4,6,2,5,0};

        // then
        Assertions.assertArrayEquals(expected, actual);
    }

}
