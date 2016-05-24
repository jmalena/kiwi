package kiwi.core;

import java.util.ArrayList;
import kiwi.lang.Function;
import kiwi.lang.RuntimeException;
import kiwi.lang.*;

public class Map extends Function {

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
        return getMappedList(callerScope, callable, list);
    }
    
    protected List<Expression> getMappedList(Scope callerScope, Callable callable, List<Expression> list) throws RuntimeException {
        if(list instanceof Nil) {
            return Nil.getInstance();
        }
        
        List<Expression> arguments = new Pair(list.getHead().evaluate(callerScope), Nil.getInstance());
        Expression head = callable.call(callerScope, arguments);
        List<Expression> tail = getMappedList(callerScope, callable, list.getTail());
        
        return new Pair(head, tail);
    }
}
