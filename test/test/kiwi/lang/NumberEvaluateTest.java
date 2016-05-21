package test.kiwi.lang;

import org.junit.Test;
import static org.junit.Assert.*;
import kiwi.lang.Number;
import kiwi.lang.RuntimeException;
import kiwi.lang.*;

public class NumberEvaluateTest {

    @Test
    public void testEvaluate() throws RuntimeException {
        assertEquals(new Number(1), new Number(1).evaluate(new Scope()));
    }
}
