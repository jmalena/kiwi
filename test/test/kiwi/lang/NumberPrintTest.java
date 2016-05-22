package test.kiwi.lang;

import org.junit.Test;
import static org.junit.Assert.*;
import kiwi.lang.Number;

public class NumberPrintTest {
    
    @Test
    public void testPrintWholeNumber() {
        assertEquals("1", new Number(1).toString());
    }
    
    @Test
    public void testPrintDecimalNumber() {
        assertEquals("1.5", new Number(1.5).toString());
    }
}
