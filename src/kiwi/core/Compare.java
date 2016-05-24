package kiwi.core;

import java.util.ArrayList;
import kiwi.lang.Number;
import kiwi.lang.RuntimeException;
import kiwi.lang.*;

public class Compare extends Function {

    public enum Operator {
        GT(1, 1),
        GTE(0, 1),
        LT(-1, -1),
        LTE(-1, 0);
        
        protected int min, max;
        
        private Operator(int min, int max) {
            this.min = min;
            this.max = max;
        }
        
        boolean satisfy(int compare) {
            return compare >= min && compare <= max;
        }
    }
    
    protected Operator operator;

    public Compare(Operator operator) {
        this.operator = operator;
    }

    @Override
    public ArrayList<Parameter> getParameters() {
        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(new Parameter(new Symbol("number")));
        parameters.add(new Parameter(new Symbol("numbers"), true));
        return parameters;
    }

    @Override
    public Expression getResult(Scope callerScope, Scope calleeScope) throws RuntimeException {
        Number number = (Number)calleeScope.get(new Symbol("number"));
        List<Number> numbers = (List<Number>)calleeScope.get(new Symbol("numbers"));
        
        double leftOperand = number.getValue();
        
        while(!(numbers instanceof Nil)) {
            double rightOperand = numbers.getHead().getValue();
            int result = Double.compare(leftOperand, rightOperand);
            
            if(!operator.satisfy(result)) {
                return Nil.getInstance();
            }
            
            leftOperand = rightOperand;
            numbers = numbers.getTail();
        }
        
        return True.getInstance();
    }
}
