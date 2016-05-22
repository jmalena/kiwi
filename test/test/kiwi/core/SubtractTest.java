package test.kiwi.core;

import org.junit.Test;
import static org.junit.Assert.*;
import kiwi.core.Subtract;
import kiwi.lang.Number;
import kiwi.lang.RuntimeException;
import kiwi.lang.*;

public class SubtractTest {
    
    @Test
    public void testSubtractSingle() throws RuntimeException {
        List<Expression> arguments = new Pair(new Number(1), Nil.getInstance());
        assertEquals(new Number(-1), new Subtract().call(new Scope(), arguments));
    }
    
    @Test
    public void testSubtractMultiple() throws RuntimeException {
        List<Expression> arguments = new Pair(new Number(1), new Pair(new Number(3), new Pair(new Number(5), Nil.getInstance())));
        assertEquals(new Number(-7), new Subtract().call(new Scope(), arguments));
    }
}
