package test.kiwi.core;

import org.junit.Test;
import static org.junit.Assert.*;
import kiwi.core.Function;
import kiwi.lang.Number;
import kiwi.lang.RuntimeException;
import kiwi.lang.*;

public class FunctionTest {
    
    @Test
    public void testRuntimeFunction() throws RuntimeException {
        Scope scope = new Scope();
        scope.set(new Symbol("foo"), new Number(1));
        
        Function function = new Function();
        List<Symbol> parametersArgument = new Pair(new Symbol("a"), Nil.getInstance());
        Expression bodyArgument = new Symbol("a");
        List<Expression> arguments = new Pair(parametersArgument, new Pair(bodyArgument, Nil.getInstance()));
        
        Function.RuntimeFunction runtimeFunction = (Function.RuntimeFunction)function.call(scope, arguments);
        assertEquals(new Number(1), runtimeFunction.call(scope, new Pair(new Symbol("foo"), Nil.getInstance())));
    }
    
    @Test
    public void testRuntimeFunctionRestParameter() throws RuntimeException {
        Scope scope = new Scope();
        scope.set(new Symbol("foo"), new Number(2));
        
        Function function = new Function();
        List<Symbol> parametersArgument = new Pair(new Symbol("a"), new Pair(new Symbol("..bs"), Nil.getInstance()));
        Expression bodyArgument = new Symbol("bs");
        List<Expression> arguments = new Pair(parametersArgument, new Pair(bodyArgument, Nil.getInstance()));
        
        Function.RuntimeFunction runtimeFunction = (Function.RuntimeFunction)function.call(scope, arguments);
        List<Expression> runtimeArguments = new Pair(new Number(1), new Pair(new Symbol("foo"), Nil.getInstance()));
        assertEquals(new Pair(new Number(2), Nil.getInstance()), runtimeFunction.call(scope, runtimeArguments));
    }
}
