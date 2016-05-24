package kiwi.interpreter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import kiwi.lexer.*;
import kiwi.parser.*;
import kiwi.lang.RuntimeException;
import kiwi.lang.*;

public class FileInterpreter {

    public FileInterpreter(String path) {
        String input = "";
        
        try {
            input = getFileContent(path);
        } catch(IOException e) {
            System.out.println("Unable to open file " + path);
        }
        
        Scope scope = Interpreter.createDefaultScope();
        
        try {
            for(Expression expression : Parser.parse(Lexer.lex(input))) {
                expression.evaluate(scope);
            }
        } catch(ParserException e) {
            System.err.println("Parser error: " + e.getMessage());
        } catch(RuntimeException e) {
            System.err.println("Runtime error: " + e.getMessage());
        } catch(Exception e) {
            System.err.println(e);
        }
    }
    
    protected String getFileContent(String path) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        return new String(bytes, Charset.defaultCharset());
    }
}
