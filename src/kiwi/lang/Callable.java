package kiwi.lang;

import java.util.ArrayList;

public abstract class Callable implements Expression {

    public abstract ArrayList<Parameter> getParameters();
    
    public abstract Expression getResult(Scope callerScope, Scope calleeScope) throws RuntimeException;
    
    public Expression call(Scope callerScope, List<Expression> arguments) throws RuntimeException {
        return getResult(callerScope, getCalleeScope(callerScope, arguments));
    }
    
    protected Scope getCalleeScope(Scope callerScope, List<Expression> arguments) throws RuntimeException {
        Scope calleScope = new Scope(callerScope);
        boolean rest = false;
        
        for(Parameter parameter : getParameters()) {
            if(rest) {
                throw new RuntimeException("Rest parameter must be last parameter");
            } else if(parameter.isRest()) {
                rest = true;
                calleScope.set(parameter.getName(), arguments);
                arguments = Nil.getInstance();
            } else {
                if(arguments instanceof Nil) {
                    throw new RuntimeException("Passed too few arguments to callable");
                }
            
                calleScope.set(parameter.getName(), arguments.getHead());
                arguments = arguments.getTail();
            }
        }
        
        if(!(arguments instanceof Nil)) {
            throw new RuntimeException("Passed too many arguments to callable");
        }
        
        return calleScope;
    }
    
    @Override
    public Expression evaluate(Scope scope) throws RuntimeException {
        return this;
    }
}
