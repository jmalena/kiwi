package kiwi.interpreter;

import kiwi.lang.*;
import kiwi.core.Quote;
import kiwi.core.*;

public class Interpreter {
    public static String VERSION = "1.0.0";

    public static void main(String[] args) {
        if(args.length > 0) {
            String option = args[0];

            if(option.equals("-v") || option.equals("--version")) {
                System.out.println(VERSION);
            } else if(option.equals("-h") || option.equals("--help")) {
                printHelp();
            } else {
                new FileInterpreter(option);
            }
        } else {
            new Repl();
        }
    }

    protected static void printHelp() {
        System.out.println("Usage:\n\tkiwi [path]\n\tkiwi [options]\n\nOptions:\n\t-v, --version\tPrint version\n\t-h, --help\tPrint help");
    }

    public static Scope createDefaultScope() {
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
