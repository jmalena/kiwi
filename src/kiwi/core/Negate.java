package kiwi.core;

import java.util.ArrayList;
import kiwi.lang.RuntimeException;
import kiwi.lang.*;

public class Negate extends Function {

    @Override
    public ArrayList<Parameter> getParameters() {
        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(new Parameter(new Symbol("expression")));
        return parameters;
    }

    @Override
    public Expression getResult(Scope callerScope, Scope calleeScope) throws RuntimeException {
        Expression expression = (Expression)calleeScope.get(new Symbol("expression"));
        return expression instanceof Nil ? True.getInstance() : Nil.getInstance();
    }   
}
