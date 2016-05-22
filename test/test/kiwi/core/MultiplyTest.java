package test.kiwi.core;

import org.junit.Test;
import static org.junit.Assert.*;
import kiwi.core.Multiply;
import kiwi.lang.Number;
import kiwi.lang.RuntimeException;
import kiwi.lang.*;

public class MultiplyTest {
    
    @Test
    public void testMultiplyEmpty() throws RuntimeException {
        assertEquals(new Number(1), new Multiply().call(new Scope(), Nil.getInstance()));
    }
    
    @Test
    public void testMultiplyMultiple() throws RuntimeException {
        List<Expression> arguments = new Pair(new Number(2), new Pair(new Number(3), new Pair(new Number(5), Nil.getInstance())));
        assertEquals(new Number(30), new Multiply().call(new Scope(), arguments));
    }
}
