package test.kiwi.lang;

import org.junit.Test;
import static org.junit.Assert.*;
import kiwi.lang.Symbol;

public class SymbolEqualsTest {
    
    @Test
    public void testEqualsNull() {
        assertFalse(new Symbol("foo").equals(null));
    }
    
    @Test
    public void testEqualsSelf() {
        Symbol symbol = new Symbol("foo");
        
        assertTrue(symbol.equals(symbol));
    }
    
    @Test
    public void testEqualsDifferent() {
        assertFalse(new Symbol("foo").equals(new Symbol("bar")));
    }
    
    @Test
    public void testEqualsSame() {
        assertTrue(new Symbol("foo").equals(new Symbol("foo")));
    }
}
