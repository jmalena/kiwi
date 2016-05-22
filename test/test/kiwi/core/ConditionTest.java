package test.kiwi.core;

import org.junit.Test;
import static org.junit.Assert.*;
import kiwi.core.Condition;
import kiwi.lang.Number;
import kiwi.lang.RuntimeException;
import kiwi.lang.*;

public class ConditionTest {

    @Test
    public void testConditionNonNilPredicate() throws RuntimeException {
        Condition condition = new Condition();
        Scope scope = new Scope();
        scope.set(new Symbol("foo"), new Number(1));
        scope.set(new Symbol("bar"), new Number(2));
        scope.set(new Symbol("baz"), new Number(3));
        List<Expression> arguments = new Pair(new Symbol("foo"), new Pair(new Symbol("bar"), new Pair(new Symbol("baz"), Nil.getInstance())));
        
        assertEquals(new Number(2), condition.call(scope, arguments));
    }
    
    @Test
    public void testConditionNilPredicate() throws RuntimeException {
        Condition condition = new Condition();
        Scope scope = new Scope();
        scope.set(new Symbol("foo"), Nil.getInstance());
        scope.set(new Symbol("bar"), new Number(2));
        scope.set(new Symbol("baz"), new Number(3));
        List<Expression> arguments = new Pair(new Symbol("foo"), new Pair(new Symbol("bar"), new Pair(new Symbol("baz"), Nil.getInstance())));
        
        assertEquals(new Number(3), condition.call(scope, arguments));
    }
}
