package kiwi.interpreter;

import java.util.Scanner;
import kiwi.lexer.*;
import kiwi.parser.*;
import kiwi.lang.RuntimeException;
import kiwi.lang.*;

public class Repl {
    protected static String PROMPT = "> ";

    public Repl() {
        System.out.println("Welcome to Kiwi REPL (" + Interpreter.VERSION + "):");
        
        Scanner scanner = new Scanner(System.in);
        Scope scope = Interpreter.createDefaultScope();
        
        while(true) {
            System.out.print(PROMPT);
            String input = scanner.nextLine();
            
            try {
                for(Expression expression : Parser.parse(Lexer.lex(input))) {
                    Expression result = expression.evaluate(scope);
                    System.out.println(result);
                }
            } catch(ParserException e) {
                System.err.println("Parser error: " + e.getMessage());
            } catch(RuntimeException e) {
                System.err.println("Runtime error: " + e.getMessage());
            } catch(Exception e) {
                System.err.println(e);
            }
        }
    }
}
