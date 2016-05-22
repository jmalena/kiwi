package test.kiwi.lang;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import kiwi.lang.Number;
import kiwi.lang.RuntimeException;
import kiwi.lang.*;

public class PairEvaluateTest {

    private class One extends Callable {

        @Override
        public ArrayList<Parameter> getParameters() {
            return new ArrayList<>();
        }

        @Override
        public Expression getResult(Scope callerScope, Scope calleeScope) throws RuntimeException {
            return new Number(1);
        }
    }
    
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
        One one = new One();
        Scope scope = new Scope();
        scope.set(new Symbol("one"), one);
        
        assertEquals(new Number(1), new Pair(one, Nil.getInstance()).evaluate(scope));
        assertEquals(new Number(1), new Pair(new Symbol("one"), Nil.getInstance()).evaluate(scope));
    }
}
