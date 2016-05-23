package kiwi.core;

import java.util.ArrayList;
import kiwi.lang.Function;
import kiwi.lang.RuntimeException;
import kiwi.lang.*;

public class Equals extends Function {

    @Override
    public ArrayList<Parameter> getParameters() {
        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(new Parameter(new Symbol("expression")));
        parameters.add(new Parameter(new Symbol("expressions"), true));
        return parameters;
    }

    @Override
    public Expression getResult(Scope callerScope, Scope calleeScope) throws RuntimeException {
        Expression expression = calleeScope.get(new Symbol("expression"));
        List<Expression> expressions = (List<Expression>)calleeScope.get(new Symbol("expressions"));
        
        while(!(expressions instanceof Nil)) {
            if(!expressions.getHead().equals(expression)) {
                return Nil.getInstance();
            }
            
            expressions = expressions.getTail();
        }
        
        return True.getInstance();
    }
}
