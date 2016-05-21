package kiwi.lang;

import java.util.HashMap;

public class Scope {
    Scope parent;
    HashMap<Symbol, Expression> expressions = new HashMap<>();
    
    public Scope() {
        this.parent = null;
    }
    
    public Scope(Scope parent) {
        this.parent = parent;
    }
    
    public Scope set(Symbol symbol, Expression expression) {
        expressions.put(symbol, expression);
        
        return this;
    }
    
    public Expression get(Symbol symbol) {
        if(!expressions.containsKey(symbol)) {
            if(parent == null) {
                return null;
            }
            
            return parent.get(symbol);
        }
        
        return expressions.get(symbol);
    }
}
