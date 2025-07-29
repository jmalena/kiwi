package kiwi.cli;

import kiwi.lang.*;
import kiwi.core.*;

public abstract class Interpreter {
    public static String VERSION = "0.1.0";
    
    protected static Scope createDefaultScope() {
        Scope scope = new Scope();
        scope.set(new Symbol("nil"), Nil.getInstance());
        scope.set(new Symbol("t"), True.getInstance());
        scope.set(new Symbol("fun"), new FunctionFactory());
        scope.set(new Symbol("apply"), new Apply());
        scope.set(new Symbol("if"), new Condition());
        scope.set(new Symbol("set!"), new Assign());
        scope.set(new Symbol("quote"), new Quote());
        scope.set(new Symbol("map"), new Map());
        scope.set(new Symbol("filter"), new Filter());
        scope.set(new Symbol("range"), new Range());
        scope.set(new Symbol("not"), new Negate());
        scope.set(new Symbol("mod"), new Modulo());
        scope.set(new Symbol(">"), new Compare(Compare.Operator.GT));
        scope.set(new Symbol(">="), new Compare(Compare.Operator.GTE));
        scope.set(new Symbol("<"), new Compare(Compare.Operator.LT));
        scope.set(new Symbol("<="), new Compare(Compare.Operator.LTE));
        scope.set(new Symbol("="), new Equals());
        scope.set(new Symbol("+"), new Add());
        scope.set(new Symbol("-"), new Subtract());
        scope.set(new Symbol("*"), new Multiply());
        scope.set(new Symbol("/"), new Divide());
        scope.set(new Symbol("time"), new Time());
        scope.set(new Symbol("println"), new PrintLine());
        return scope;
    }
}
