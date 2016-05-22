package kiwi.core;

import java.util.ArrayList;
import kiwi.lang.RuntimeException;
import kiwi.lang.*;

public class Function extends Callable {
    
    public class RuntimeFunction extends kiwi.lang.Function {
        protected ArrayList<Parameter> parameters = new ArrayList<>();
        protected Expression body;

        public RuntimeFunction(List<Symbol> parameters, Expression body) {
            while(!(parameters instanceof Nil)) {
                String name = parameters.getHead().getValue();

                Parameter parameter;
                if(name.length() > 3 && name.startsWith("..")) {
                    name = name.substring(2);
                    parameter = new Parameter(new Symbol(name), true);
                } else {
                    parameter = new Parameter(parameters.getHead());
                }

                this.parameters.add(parameter);
                parameters = parameters.getTail();
            }

            this.body = body;
        }

        @Override
        public ArrayList<Parameter> getParameters() {
            return parameters;
        }

        @Override
        public Expression getResult(Scope callerScope, Scope calleeScope) throws RuntimeException {
            return body.evaluate(calleeScope);
        }
    }

    @Override
    public ArrayList<Parameter> getParameters() {
        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(new Parameter(new Symbol("parameters")));
        parameters.add(new Parameter(new Symbol("body")));
        return parameters;
    }

    @Override
    public Expression getResult(Scope callerScope, Scope calleeScope) throws RuntimeException {
        List<Symbol> parameters = (List<Symbol>)calleeScope.get(new Symbol("parameters"));
        Expression body = calleeScope.get(new Symbol("body"));
        return new RuntimeFunction(parameters, body);
    }
}
