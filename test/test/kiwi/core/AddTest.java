package test.kiwi.core;

import org.junit.Test;
import static org.junit.Assert.*;
import kiwi.core.Add;
import kiwi.lang.Number;
import kiwi.lang.RuntimeException;
import kiwi.lang.*;

public class AddTest {
    
    @Test
    public void testAddEmpty() throws RuntimeException {
        assertEquals(new Number(0), new Add().call(new Scope(), Nil.getInstance()));
    }
    
    @Test
    public void testAddMultiple() throws RuntimeException {
        List<Expression> arguments = new Pair(new Number(1), new Pair(new Number(3), new Pair(new Number(5), Nil.getInstance())));
        assertEquals(new Number(9), new Add().call(new Scope(), arguments));
    }
}
