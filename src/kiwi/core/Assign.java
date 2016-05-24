package kiwi.core;

import java.util.ArrayList;
import kiwi.lang.RuntimeException;
import kiwi.lang.*;

public class Assign extends Callable {

    @Override
    public ArrayList<Parameter> getParameters() {
        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(new Parameter(new Symbol("symbol")));
        parameters.add(new Parameter(new Symbol("expression")));
        return parameters;
    }

    @Override
    public Expression getResult(Scope callerScope, Scope calleeScope) throws RuntimeException {
        Symbol symbol = (Symbol)calleeScope.get(new Symbol("symbol"));
        Expression expression = calleeScope.get(new Symbol("expression")).evaluate(callerScope);
        callerScope.set(symbol, expression);
        return expression;
    }
}
