package test.kiwi.parser;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import kiwi.parser.*;
import kiwi.lexer.*;
import kiwi.lang.Number;
import kiwi.lang.*;

public class ParserTest {
    
    @Test
    public void testParseEmpty() throws ParserException {
        ArrayList<Expression> expressions = Parser.parse(Lexer.lex(""));
        assertEquals(0, expressions.size());
    }
    
    @Test
    public void testParseNumber() throws ParserException {
        ArrayList<Expression> expressions = Parser.parse(Lexer.lex("1 1.5"));
        
        assertEquals(2, expressions.size());
        assertEquals(new Number(1), expressions.get(0));
        assertEquals(new Number(1.5), expressions.get(1));
    }
    
    @Test
    public void testParseSymbol() throws ParserException {
        ArrayList<Expression> expressions = Parser.parse(Lexer.lex("foo bar"));
        
        assertEquals(2, expressions.size());
        assertEquals(new Symbol("foo"), expressions.get(0));
        assertEquals(new Symbol("bar"), expressions.get(1));
    }
    
    @Test
    public void testParseIncompleteList1() {
        try {
            Parser.parse(Lexer.lex("("));
            fail();
        } catch(ParserException e) {
            assertEquals("Expected closing parentheses", e.getMessage());
        }
    }
    
    @Test
    public void testParseIncompleteList2() {
        try {
            Parser.parse(Lexer.lex(")"));
            fail();
        } catch(ParserException e) {
            assertEquals("Unexpected end of file", e.getMessage());
        }
    }
    
    @Test
    public void testParseList1() throws ParserException {
        ArrayList<Expression> expressions = Parser.parse(Lexer.lex("()()"));
        
        assertEquals(2, expressions.size());
        assertEquals(Nil.getInstance(), expressions.get(0));
        assertEquals(Nil.getInstance(), expressions.get(1));
    }
    
    @Test
    public void testParseList2() throws ParserException {
        ArrayList<Expression> expressions = Parser.parse(Lexer.lex("(foo (bar 1) 2)"));
        
        assertEquals(1, expressions.size());
        List<Expression> innerList = new Pair(new Symbol("bar"), new Pair(new Number(1), Nil.getInstance()));
        List<Expression> list = new Pair(new Symbol("foo"), new Pair(innerList, new Pair(new Number(2), Nil.getInstance())));
        assertEquals(list, expressions.get(0));
    }
}
