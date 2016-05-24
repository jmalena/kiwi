package kiwi.core;

import java.util.ArrayList;
import kiwi.lang.Function;
import kiwi.lang.RuntimeException;
import kiwi.lang.*;

public class Filter extends Function {

    @Override
    public ArrayList<Parameter> getParameters() {
        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(new Parameter(new Symbol("callable")));
        parameters.add(new Parameter(new Symbol("list")));
        return parameters;
    }

    @Override
    public Expression getResult(Scope callerScope, Scope calleeScope) throws RuntimeException {
        Callable callable = (Callable)calleeScope.get(new Symbol("callable"));
        List<Expression> list = (List<Expression>)calleeScope.get(new Symbol("list"));
        return getFilteredList(callerScope, callable, list);
    }
    
    protected List<Expression> getFilteredList(Scope callerScope, Callable callable, List<Expression> list) throws RuntimeException {
        if(list instanceof Nil) {
            return Nil.getInstance();
        }
        
        Expression value = list.getHead().evaluate(callerScope);
        List<Expression> arguments = new Pair(value, Nil.getInstance());
        Expression head = callable.call(callerScope, arguments);
        List<Expression> tail = getFilteredList(callerScope, callable, list.getTail());
        
        if(head instanceof Nil) {
            return tail;
        }
        
        return new Pair(value, tail);
    }
}
