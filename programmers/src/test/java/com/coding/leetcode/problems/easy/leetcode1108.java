package com.coding.leetcode.problems.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/defanging-an-ip-address/
 */
public class leetcode1108 {
    
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }

    @DisplayName("1.1.1.1")
    @Test
    public void test() {
        assertEquals(defangIPaddr("1.1.1.1"), "1[.]1[.]1[.]1");
    }

    @DisplayName("255.100.50.0")
    @Test
    public void test2() {
        assertEquals(defangIPaddr("255.100.50.0"), "255[.]100[.]50[.]0");
    }

}