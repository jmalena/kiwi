package test.kiwi.lang;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import kiwi.lang.Number;
import kiwi.lang.RuntimeException;
import kiwi.lang.*;

public class FunctionTest {
    
    private class Identity extends Function {

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
    
    private class Rest extends Function {

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
    
    @Test
    public void testEvaluateArgument() throws RuntimeException {
        Identity callable = new Identity();
        Scope scope = new Scope();
        scope.set(new Symbol("foo"), new Number(1));
        List<Expression> arguments = new Pair(new Symbol("foo"), Nil.getInstance());
        
        assertEquals(new Number(1), callable.call(scope, arguments));
    }
    
    @Test
    public void testEvaluateRestArgument() throws RuntimeException {
        Rest callable = new Rest();
        Scope scope = new Scope();
        scope.set(new Symbol("foo"), new Number(1));
        List<Expression> arguments = new Pair(new Number(1), new Pair(new Symbol("foo"), Nil.getInstance()));
        
        assertEquals(new Pair(new Number(1), Nil.getInstance()), callable.call(scope, arguments));
    }
}
