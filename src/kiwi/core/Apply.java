package kiwi.core;

import java.util.ArrayList;
import kiwi.lang.RuntimeException;
import kiwi.lang.*;

public class Apply extends Function {

    @Override
    public ArrayList<Parameter> getParameters() {
        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(new Parameter(new Symbol("callable")));
        parameters.add(new Parameter(new Symbol("arguments")));
        return parameters;
    }

    @Override
    public Expression getResult(Scope callerScope, Scope calleeScope) throws RuntimeException {
        Callable callable = (Callable)calleeScope.get(new Symbol("callable"));
        List<Expression> arguments = (List<Expression>)calleeScope.get(new Symbol("arguments"));
        return callable.call(callerScope, arguments);
    }
}
