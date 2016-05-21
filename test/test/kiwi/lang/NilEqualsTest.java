package test.kiwi.lang;

import org.junit.Test;
import static org.junit.Assert.*;
import kiwi.lang.*;

public class NilEqualsTest {

    @Test
    public void testEqualsNull() {
        assertFalse(Nil.getInstance().equals(null));
    }
    
    @Test
    public void testEqualsSelf() {
        assertTrue(Nil.getInstance().equals(Nil.getInstance()));
    }
}
