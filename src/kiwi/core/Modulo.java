package kiwi.core;

import java.util.ArrayList;
import kiwi.lang.Number;
import kiwi.lang.RuntimeException;
import kiwi.lang.*;

public class Modulo extends Function {

    @Override
    public ArrayList<Parameter> getParameters() {
        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(new Parameter(new Symbol("leftOperator")));
        parameters.add(new Parameter(new Symbol("rightOperator")));
        return parameters;
    }

    @Override
    public Expression getResult(Scope callerScope, Scope calleeScope) throws RuntimeException {
        Number leftOperator = (Number)calleeScope.get(new Symbol("leftOperator"));
        Number rightOperator = (Number)calleeScope.get(new Symbol("rightOperator"));
        return new Number(leftOperator.getValue() % rightOperator.getValue());
    }
}
