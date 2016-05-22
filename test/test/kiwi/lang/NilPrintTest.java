package test.kiwi.lang;

import org.junit.Test;
import static org.junit.Assert.*;
import kiwi.lang.Nil;

public class NilPrintTest {

    @Test
    public void testPrintNil() {
        assertEquals("nil", Nil.getInstance().toString());
    }
}
