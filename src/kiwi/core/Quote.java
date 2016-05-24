package kiwi.core;

import java.util.ArrayList;
import kiwi.lang.RuntimeException;
import kiwi.lang.*;

public class Quote extends Callable {

    @Override
    public ArrayList<Parameter> getParameters() {
        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(new Parameter(new Symbol("expression")));
        return parameters;
    }

    @Override
    public Expression getResult(Scope callerScope, Scope calleeScope) throws RuntimeException {
        return calleeScope.get(new Symbol("expression"));
    }
}
