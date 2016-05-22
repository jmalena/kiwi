package test.kiwi.lang;

import org.junit.Test;
import static org.junit.Assert.*;
import kiwi.lang.Number;
import kiwi.lang.RuntimeException;
import kiwi.lang.*;

public class PairEvaluateTest {

    @Test
    public void testEvaluateNotCallable() throws RuntimeException {
        List<Number> list = new Pair(new Number(1), Nil.getInstance());
        
        try {
            list.evaluate(new Scope());
            fail();
        } catch(ClassCastException e) {}
    }
    
    @Test
    public void testEvaluateCallable() throws RuntimeException {
        RuntimeFunction one = new RuntimeFunction(Nil.getInstance(), new Number(1));
        Scope scope = new Scope();
        scope.set(new Symbol("one"), one);
        
        assertEquals(new Number(1), new Pair(one, Nil.getInstance()).evaluate(scope));
        assertEquals(new Number(1), new Pair(new Symbol("one"), Nil.getInstance()).evaluate(scope));
    }
}
