package test.kiwi.lang;

import org.junit.Test;
import static org.junit.Assert.*;
import kiwi.lang.Symbol;

public class SymbolPrintTest {
    
    @Test
    public void testPrintSymbol() {
        assertEquals("foo", new Symbol("foo").toString());
    }
}
