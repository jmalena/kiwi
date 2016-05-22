package test.kiwi.lang;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import kiwi.lang.Number;
import kiwi.lang.RuntimeException;
import kiwi.lang.*;

public class CallableTest {
    
    private class Identity extends Callable {

        @Override
        public ArrayList<Parameter> getParameters() {
            ArrayList<Parameter> parameters = new ArrayList<>();
            parameters.add(new Parameter(new Symbol("a"), false));
            return parameters;
        }

        @Override
        public Expression getResult(Scope callerScope, Scope calleeScope) throws RuntimeException {
            return calleeScope.get(new Symbol("a"));
        }
    }
    
    private class Rest extends Callable {

        @Override
        public ArrayList<Parameter> getParameters() {
            ArrayList<Parameter> parameters = new ArrayList<>();
            parameters.add(new Parameter(new Symbol("a"), false));
            parameters.add(new Parameter(new Symbol("bs"), true));
            return parameters;
        }

        @Override
        public Expression getResult(Scope callerScope, Scope calleeScope) throws RuntimeException {
            return calleeScope.get(new Symbol("bs"));
        }
    }
    
    private class NonLastRest extends Callable {

        @Override
        public ArrayList<Parameter> getParameters() {
            ArrayList<Parameter> parameters = new ArrayList<>();
            parameters.add(new Parameter(new Symbol("as"), true));
            parameters.add(new Parameter(new Symbol("b"), false));
            return parameters;
        }

        @Override
        public Expression getResult(Scope callerScope, Scope calleeScope) throws RuntimeException {
            return Nil.getInstance();
        }
    }
    
    @Test
    public void testFewArguments() {
        Identity callable = new Identity();
        
        try {
            callable.call(new Scope(), Nil.getInstance());
            fail();
        } catch(RuntimeException e) {
            assertEquals("Passed too few arguments to callable", e.getMessage());
        }
    }
    
    @Test
    public void testManyArguments() {
        Identity callable = new Identity();
        List<Expression> arguments = new Pair(new Number(1), new Pair(new Number(2), Nil.getInstance()));
        
        try {
            callable.call(new Scope(), arguments);
            fail();
        } catch(RuntimeException e) {
            assertEquals("Passed too many arguments to callable", e.getMessage());
        }
    }
    
    @Test
    public void testNonLastRestParameter() {
        NonLastRest callable = new NonLastRest();
        
        try {
            callable.call(new Scope(), Nil.getInstance());
            fail();
        } catch(RuntimeException e) {
            assertEquals("Rest parameter must be last parameter", e.getMessage());
        }
    }
    
    @Test
    public void testParameter() throws RuntimeException {
        Identity callable = new Identity();
        List<Expression> arguments = new Pair(new Symbol("foo"), Nil.getInstance());
        
        assertEquals(new Symbol("foo"), callable.call(new Scope(), arguments));
    }
    
    @Test
    public void testRestParameter() throws RuntimeException {
        Rest callable = new Rest();
        List<Expression> arguments1 = new Pair(new Number(1), Nil.getInstance());
        List<Expression> arguments2 = new Pair(new Number(1), new Pair(new Symbol("foo"), Nil.getInstance()));
        
        assertEquals(Nil.getInstance(), callable.call(new Scope(), arguments1));
        assertEquals(new Pair(new Symbol("foo"), Nil.getInstance()), callable.call(new Scope(), arguments2));
    }
}
