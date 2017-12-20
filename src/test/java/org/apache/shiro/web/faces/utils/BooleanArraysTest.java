package org.apache.shiro.web.faces.utils;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.apache.shiro.web.faces.utils.BooleanArrays.*;

public class BooleanArraysTest {
    
    private static final boolean[] EMPTY = new boolean[] {};
    private static final boolean[] FALSE = new boolean[] { false };
    private static final boolean[] TRUE = new boolean[] { true };
    private static final boolean[][] ARRAY = new boolean[][] {
        {false, false},
        {false, true},
        {true, false},
        {true, true}
    };
    
    @Test
    public void test_anyTrue() {
        assertFalse(anyTrue(EMPTY));
        assertFalse(anyTrue(FALSE));
        assertTrue(anyTrue(TRUE));
        assertFalse(anyTrue(ARRAY[0]));
        assertTrue(anyTrue(ARRAY[1]));
        assertTrue(anyTrue(ARRAY[2]));
        assertTrue(anyTrue(ARRAY[3]));
    }
    
}
