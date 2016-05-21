package test.kiwi.lang;

import org.junit.Test;
import static org.junit.Assert.*;
import kiwi.lang.Number;

public class NumberEqualsTest {

    @Test
    public void testEqualsNull() {
        assertFalse(new Number(1).equals(null));
    }
    
    @Test
    public void testEqualsSelf() {
        Number number = new Number(1);
        
        assertTrue(number.equals(number));
    }
    
    @Test
    public void testEqualsDifferent() {
        assertFalse(new Number(1).equals(new Number(2)));
    }
    
    @Test
    public void testEqualsSame() {
        assertTrue(new Number(1).equals(new Number(1)));
    }
}
