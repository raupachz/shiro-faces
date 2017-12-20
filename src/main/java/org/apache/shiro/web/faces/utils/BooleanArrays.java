package org.apache.shiro.web.faces.utils;

/**
 * We assert every parameter is non-null
 * 
 * @author Björn Raupach
 */
public class BooleanArrays {
    
    private BooleanArrays() {}
    
    public static boolean anyTrue(boolean[] a) {
        boolean anyTrue = false;
        for (boolean b : a) {
            anyTrue = anyTrue || b;
        } 
        return anyTrue;
    }
    
}
