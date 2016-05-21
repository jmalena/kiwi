package kiwi.lang;

public interface Expression {
    public Expression evaluate(Scope scope);
}
