package kiwi.core;

import java.util.ArrayList;
import kiwi.lang.Number;
import kiwi.lang.Function;
import kiwi.lang.RuntimeException;
import kiwi.lang.*;

public class Multiply extends Function {

    @Override
    public ArrayList<Parameter> getParameters() {
        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(new Parameter(new Symbol("numbers"), true));
        return parameters;
    }

    @Override
    public Expression getResult(Scope callerScope, Scope calleeScope) throws RuntimeException {
        List<Number> numbers = (List<Number>)calleeScope.get(new Symbol("numbers"));
        double accumulator = 1;
        
        while(!(numbers instanceof Nil)) {
            accumulator *= numbers.getHead().getValue();
            numbers = numbers.getTail();
        }
        
        return new Number(accumulator);
    }
}
