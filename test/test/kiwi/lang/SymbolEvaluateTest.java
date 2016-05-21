package test.kiwi.lang;

import org.junit.Test;
import static org.junit.Assert.*;
import kiwi.lang.RuntimeException;
import kiwi.lang.*;

public class SymbolEvaluateTest {
    
    @Test
    public void testEvaluateUndefinedSymbol() {
        try {
            new Symbol("foo").evaluate(new Scope());
            fail();
        } catch(RuntimeException e) {
            assertEquals("Unable to resolve symbol \"foo\" in this context", e.getMessage());
        }
    }
    
    @Test
    public void testEvaluateDefinedSymbol() throws RuntimeException {
        Scope scope = new Scope();
        scope.set(new Symbol("foo"), new Symbol("bar"));
        
        assertEquals(new Symbol("bar"), new Symbol("foo").evaluate(scope));
    }
}
