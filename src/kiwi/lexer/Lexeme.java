package kiwi.lexer;

import java.util.regex.Pattern;

public class Lexeme {

    public enum Type {
        LEFT_PARENTHESES("^\\("),
        RIGHT_PARENTHESES("^\\)"),
        NUMBER("^[+-]?\\d+(\\.\\d+)?"),
        SYMBOL("^[^\\s\\(\\)]+"),
        WHITESPACE("^\\s+");

        protected Pattern pattern;

        private Type(String regex) {
            this.pattern = Pattern.compile(regex);
        }

        public Pattern getPattern() {
            return pattern;
        }
    }
    
    protected Type type;
    protected String value;

    public Lexeme(Type type, String value) {
        this.type = type;
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
