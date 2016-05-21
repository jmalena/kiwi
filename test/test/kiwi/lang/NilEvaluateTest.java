package test.kiwi.lang;

import org.junit.Test;
import static org.junit.Assert.*;
import kiwi.lang.RuntimeException;
import kiwi.lang.*;

public class NilEvaluateTest {

    @Test
    public void testEvaluate() throws RuntimeException {
        assertEquals(Nil.getInstance(), Nil.getInstance().evaluate(new Scope()));
    }
}
