package kiwi.core;

import java.util.ArrayList;
import kiwi.lang.RuntimeException;
import kiwi.lang.*;

public class Condition extends Callable {

    @Override
    public ArrayList<Parameter> getParameters() {
        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(new Parameter(new Symbol("predicate")));
        parameters.add(new Parameter(new Symbol("then")));
        parameters.add(new Parameter(new Symbol("otherwise")));
        return parameters;
    }

    @Override
    public Expression getResult(Scope callerScope, Scope calleeScope) throws RuntimeException {
        Expression predicate = (Expression)calleeScope.get(new Symbol("predicate")).evaluate(callerScope);
        Expression then = (Expression)calleeScope.get(new Symbol("then"));
        Expression otherwise = (Expression)calleeScope.get(new Symbol("otherwise"));
        
        if(predicate instanceof Nil) {
            return otherwise.evaluate(callerScope);
        }
        
        return then.evaluate(callerScope);
    }
}
