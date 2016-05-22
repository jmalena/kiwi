package kiwi.parser;

import java.util.ArrayList;
import kiwi.lang.Number;
import kiwi.lang.*;
import kiwi.lexer.*;

public class Parser {
    protected ArrayList<Lexeme> lexemes;
    protected int position;

    protected Parser(ArrayList<Lexeme> lexemes) {
        this.lexemes = lexemes;
    }
    
    public static ArrayList<Expression> parse(ArrayList<Lexeme> lexemes) throws ParserException {
        Parser parser = new Parser(lexemes);
        
        ArrayList<Expression> expressions = new ArrayList<>();
        
        Expression expression;
        while((expression = parser.parseExpression()) != null) {
            expressions.add(expression);
        }
        
        if(!parser.isEof()) {
            throw new ParserException("Unexpected end of file");
        }
        
        return expressions;
    }
    
    protected boolean isEof() {
        return position >= lexemes.size();
    }
    
    protected boolean isNext(Lexeme.Type type) {
        return !isEof() && lexemes.get(position).getType() == type;
    }
    
    protected Expression parseExpression() throws ParserException {
        Expression expression;
        
        if((expression = parseList()) != null) {
            return expression;
        } else if((expression = parseNumber()) != null) {
            return expression;
        } else if((expression = parseSymbol()) != null) {
            return expression;
        }
        
        return null;
    }
    
    protected List<Expression> parseList() throws ParserException {
        if(!isNext(Lexeme.Type.LEFT_PARENTHESES)) {
            return null;
        }
        
        position++;
        
        List<Expression> list = parseListContent();
        
        if(!isNext(Lexeme.Type.RIGHT_PARENTHESES)) {
            throw new ParserException("Expected closing parentheses");
        }
        
        position++;
        
        return list;
    }
    
    protected List<Expression> parseListContent() throws ParserException {
        Expression expression = parseExpression();
        
        if(expression == null) {
            return Nil.getInstance();
        }
            
        return new Pair(expression, parseListContent());
    }
    
    protected Number parseNumber() {
        if(!isNext(Lexeme.Type.NUMBER)) {
            return null;
        }
        
        double value = Double.parseDouble(lexemes.get(position).getValue());
        Number number = new Number(value);
        
        position++;
        
        return number;
    }
    
    protected Symbol parseSymbol() {
        if(!isNext(Lexeme.Type.SYMBOL)) {
            return null;
        }
        
        String value = lexemes.get(position).getValue();
        Symbol symbol = new Symbol(value);
        
        position++;
        
        return symbol;
    }
}
