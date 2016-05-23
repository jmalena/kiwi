package test.kiwi.core;

import org.junit.Test;
import static org.junit.Assert.*;
import kiwi.core.Equals;
import kiwi.lang.Number;
import kiwi.lang.RuntimeException;
import kiwi.lang.*;

public class EqualsTest {
    
    @Test
    public void testEqualsEmpty() {
        try {
            new Equals().call(new Scope(), Nil.getInstance());
            fail();
        } catch(RuntimeException e) {
            assertEquals("Passed too few arguments to callable", e.getMessage());
        }
    }
    
    @Test
    public void testEqualsMultiple() throws RuntimeException {
        Scope scope = new Scope();
        scope.set(new Symbol("one"), new Number(1));
        scope.set(new Symbol("two"), new Number(2));
        List<Expression> arguments1 = new Pair(new Symbol("one"), Nil.getInstance());
        List<Expression> arguments2 = new Pair(new Symbol("two"), Nil.getInstance());
        List<Expression> arguments3 = new Pair(new Symbol("one"), new Pair(new Symbol("two"), Nil.getInstance()));
        List<Expression> arguments4 = new Pair(new Symbol("one"), new Pair(new Symbol("one"), Nil.getInstance()));
        List<Expression> arguments5 = new Pair(new Symbol("one"), new Pair(new Symbol("one"), new Pair(new Symbol("two"), Nil.getInstance())));
        List<Expression> arguments6 = new Pair(new Symbol("one"), new Pair(new Symbol("one"), new Pair(new Symbol("one"), Nil.getInstance())));
        
        assertEquals(True.getInstance(), new Equals().call(scope, arguments1));
        assertEquals(True.getInstance(), new Equals().call(scope, arguments2));
        assertEquals(Nil.getInstance(), new Equals().call(scope, arguments3));
        assertEquals(True.getInstance(), new Equals().call(scope, arguments4));
        assertEquals(Nil.getInstance(), new Equals().call(scope, arguments5));
        assertEquals(True.getInstance(), new Equals().call(scope, arguments6));
    }
}
