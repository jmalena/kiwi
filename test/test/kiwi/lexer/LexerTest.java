package test.kiwi.lexer;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import kiwi.lexer.*;

public class LexerTest {
    
    protected void assertLexemesEquals(ArrayList<Lexeme> expected, ArrayList<Lexeme> actual) {
        assertEquals(expected.size(), actual.size());
        
        for(int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getType(), actual.get(i).getType());
            assertEquals(expected.get(i).getValue(), actual.get(i).getValue());
        }
    }
    
    @Test
    public void testLexEmpty() {
        assertEquals(0, Lexer.lex("").size());
    }
    
    @Test
    public void testLexSymbol() {
        ArrayList<Lexeme> expected = new ArrayList<>();
        expected.add(new Lexeme(Lexeme.Type.SYMBOL, "foo"));
        
        assertLexemesEquals(expected, Lexer.lex("foo"));
    }
    
    @Test
    public void testLexNumber1() {
        ArrayList<Lexeme> expected = new ArrayList<>();
        expected.add(new Lexeme(Lexeme.Type.NUMBER, "1"));
        
        assertLexemesEquals(expected, Lexer.lex("1"));
    }
    
    @Test
    public void testLexNumber2() {
        ArrayList<Lexeme> expected = new ArrayList<>();
        expected.add(new Lexeme(Lexeme.Type.NUMBER, "1.5"));
        
        assertLexemesEquals(expected, Lexer.lex("1.5"));
    }
    
    @Test
    public void testLexList1() {
        ArrayList<Lexeme> expected = new ArrayList<>();
        expected.add(new Lexeme(Lexeme.Type.LEFT_PARENTHESES, "("));
        expected.add(new Lexeme(Lexeme.Type.RIGHT_PARENTHESES, ")"));
        
        assertLexemesEquals(expected, Lexer.lex("()"));
    }
    
    @Test
    public void testLexList2() {
        ArrayList<Lexeme> expected = new ArrayList<>();
        expected.add(new Lexeme(Lexeme.Type.LEFT_PARENTHESES, "("));
        expected.add(new Lexeme(Lexeme.Type.SYMBOL, "foo"));
        expected.add(new Lexeme(Lexeme.Type.NUMBER, "1"));
        expected.add(new Lexeme(Lexeme.Type.NUMBER, "2"));
        expected.add(new Lexeme(Lexeme.Type.RIGHT_PARENTHESES, ")"));
        
        assertLexemesEquals(expected, Lexer.lex("(foo 1 2)"));
    }
    
    @Test
    public void testLexList3() {
        ArrayList<Lexeme> expected = new ArrayList<>();
        expected.add(new Lexeme(Lexeme.Type.LEFT_PARENTHESES, "("));
        expected.add(new Lexeme(Lexeme.Type.SYMBOL, "foo"));
        expected.add(new Lexeme(Lexeme.Type.LEFT_PARENTHESES, "("));
        expected.add(new Lexeme(Lexeme.Type.SYMBOL, "bar"));
        expected.add(new Lexeme(Lexeme.Type.NUMBER, "1"));
        expected.add(new Lexeme(Lexeme.Type.RIGHT_PARENTHESES, ")"));
        expected.add(new Lexeme(Lexeme.Type.NUMBER, "2"));
        expected.add(new Lexeme(Lexeme.Type.RIGHT_PARENTHESES, ")"));
        
        assertLexemesEquals(expected, Lexer.lex("(foo (bar 1) 2)"));
    }
}
