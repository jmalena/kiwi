package kiwi.lang;

public abstract class Function extends Callable {

    @Override
    protected Scope getCalleeScope(Scope callerScope, List<Expression> arguments) throws RuntimeException {
        Scope calleeScope = super.getCalleeScope(callerScope, arguments);
        
        // evaluate arguments in caller scope
        for(Parameter parameter : getParameters()) {
            Expression argument = calleeScope.get(parameter.getName());
            
            Expression evaluatedArgument;
            if(parameter.isRest()) {
                evaluatedArgument = getEvaluatedRestArguments(callerScope, (List<Expression>)argument);
            } else {
                evaluatedArgument = argument.evaluate(callerScope);
            }
            
            calleeScope.set(parameter.getName(), evaluatedArgument);
        }
        
        return calleeScope;
    }
    
    protected List<Expression> getEvaluatedRestArguments(Scope callerScope, List<Expression> arguments) throws RuntimeException {
        if(arguments instanceof Nil) {
            return Nil.getInstance();
        }
        
        Expression head = arguments.getHead().evaluate(callerScope);
        List<Expression> tail = getEvaluatedRestArguments(callerScope, arguments.getTail());
        
        return new Pair(head, tail);
    }
}
