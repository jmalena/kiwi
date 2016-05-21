package test.kiwi.lang;

import org.junit.Test;
import static org.junit.Assert.*;
import kiwi.lang.Number;
import kiwi.lang.*;

public class ScopeTest {

    @Test
    public void testGetUndefinedSymbol() {
        Scope scope = new Scope();
        
        assertNull(scope.get(new Symbol("foo")));
    }
    
    @Test
    public void testGetDefinedSymbol() {
        Scope rootScope = new Scope();
        Scope childScope = new Scope(rootScope);
        
        rootScope.set(new Symbol("foo"), new Number(1));
        childScope.set(new Symbol("bar"), new Number(2));
        
        assertEquals(new Number(1), rootScope.get(new Symbol("foo")));
        assertEquals(new Number(1), childScope.get(new Symbol("foo")));
        assertEquals(new Number(2), childScope.get(new Symbol("bar")));
    }
}
