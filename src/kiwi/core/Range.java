package kiwi.core;

import java.util.ArrayList;
import kiwi.lang.Number;
import kiwi.lang.RuntimeException;
import kiwi.lang.*;

public class Range extends Function {

    @Override
    public ArrayList<Parameter> getParameters() {
        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(new Parameter(new Symbol("start")));
        parameters.add(new Parameter(new Symbol("end")));
        return parameters;
    }

    @Override
    public Expression getResult(Scope callerScope, Scope calleeScope) throws RuntimeException {
        Number start = (Number)calleeScope.get(new Symbol("start"));
        Number end = (Number)calleeScope.get(new Symbol("end"));
        return createRange((int)start.getValue(), (int)end.getValue());
    }
    
    protected List<Number> createRange(int start, int end) {
        if(start > end) {
            return Nil.getInstance();
        }
        
        Number head = new Number(start);
        List<Number> tail = createRange(start + 1, end);
        
        return new Pair(head, tail);
    }
}
