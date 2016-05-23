package test.kiwi.lang;

import org.junit.Test;
import static org.junit.Assert.*;
import kiwi.lang.*;

public class TrueEqualsTest {
    
    @Test
    public void testEqualsNull() {
        assertFalse(True.getInstance().equals(null));
    }
    
    @Test
    public void testEqualsSelf() {
        assertTrue(True.getInstance().equals(True.getInstance()));
    }
}
