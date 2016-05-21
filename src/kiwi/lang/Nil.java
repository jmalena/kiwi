package kiwi.lang;

public class Nil implements List {
    private static Nil instance;
    
    private Nil() {}

    public static Nil getInstance() {
        if(instance == null) {
            instance = new Nil();
        }
        
        return instance;
    }

    @Override
    public Expression getHead() {
        return this;
    }

    @Override
    public List getTail() {
        return this;
    }

    @Override
    public Expression evaluate(Scope scope) throws RuntimeException {
        return this;
    }
}
