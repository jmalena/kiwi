package kiwi.lang;

import java.util.Objects;

public class Symbol implements Expression {
    protected String value;

    public Symbol(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Symbol)) {
            return false;
        }
        
        Symbol symbol = (Symbol)obj;
        return getValue().equals(symbol.getValue());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(value);
        return hash;
    }

    @Override
    public Expression evaluate(Scope scope) throws RuntimeException {
        Expression expression = scope.get(this);
        
        if(expression == null) {
            throw new RuntimeException("Unable to resolve symbol \"" + getValue() + "\" in this context");
        } else if(expression instanceof Symbol) {
            return expression.evaluate(scope);
        }
        
        return expression;
    }
}
