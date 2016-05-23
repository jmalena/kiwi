package test.kiwi.lang;

import org.junit.Test;
import static org.junit.Assert.*;
import kiwi.lang.*;

public class TruePrintTest {
    
    @Test
    public void testPrintTrue() {
        assertEquals("t", True.getInstance().toString());
    }
}
