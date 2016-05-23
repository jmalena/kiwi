package kiwi.lang;

public class True implements Expression {
    private static True instance;
    
    private True() {}

    public static True getInstance() {
        if(instance == null) {
            instance = new True();
        }
        
        return instance;
    }

    @Override
    public String toString() {
        return "t";
    }

    @Override
    public Expression evaluate(Scope scope) throws RuntimeException {
        return this;
    }
}
