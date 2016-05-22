package kiwi.lexer;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class Lexer {
    
    public static ArrayList<Lexeme> lex(String input) {
        ArrayList<Lexeme> lexemes = new ArrayList<>();
        
        while(input.length() > 0) {
            boolean matched = false;
            
            for(Lexeme.Type type : Lexeme.Type.values()) {
                Matcher matcher = type.getPattern().matcher(input);

                if(matcher.find()) {
                    matched = true;
                    String match = matcher.group();
                    input = input.substring(match.length());

                    if(type != Lexeme.Type.WHITESPACE) {
                        lexemes.add(new Lexeme(type, match));
                    }

                    break;
                }
            }
            
            if(!matched) {
                // should not be reached with actual set of patterns
                assert false;
            }
        }
        
        return lexemes;
    }
}
