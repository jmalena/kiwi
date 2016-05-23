package test.kiwi.core;

import org.junit.Test;
import static org.junit.Assert.*;
import kiwi.core.Divide;
import kiwi.lang.Number;
import kiwi.lang.RuntimeException;
import kiwi.lang.*;

public class DivideTest {
    
    @Test
    public void testDivideEmpty() {
        try {
            new Divide().call(new Scope(), Nil.getInstance());
            fail();
        } catch(RuntimeException e) {
            assertEquals("Passed too few arguments to callable", e.getMessage());
        }
    }
    
    @Test
    public void testDivideSingle() throws RuntimeException {
        List<Expression> arguments = new Pair(new Number(2), Nil.getInstance());
        assertEquals(new Number(1.0 / 2), new Divide().call(new Scope(), arguments));
    }
    
    @Test
    public void testDivideMultiple() throws RuntimeException {
        List<Expression> arguments = new Pair(new Number(2), new Pair(new Number(3), new Pair(new Number(5), Nil.getInstance())));
        assertEquals(new Number(2.0 / 3 / 5), new Divide().call(new Scope(), arguments));
    }
}
