package test.kiwi.lang;

import org.junit.Test;
import static org.junit.Assert.*;
import kiwi.lang.RuntimeException;
import kiwi.lang.*;

public class TrueEvaluateTest {
    
    @Test
    public void testEvaluate() throws RuntimeException {
        assertEquals(True.getInstance(), True.getInstance().evaluate(new Scope()));
    }
}
