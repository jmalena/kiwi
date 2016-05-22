package test.kiwi.lang;

import org.junit.Test;
import static org.junit.Assert.*;
import kiwi.lang.Number;
import kiwi.lang.*;

public class PairPrintTest {
    
    @Test
    public void testPrint1() {
        assertEquals("(nil)", new Pair(Nil.getInstance(), Nil.getInstance()).toString());
    }
    
    @Test
    public void testPrint2() {
        List<Expression> list = new Pair(new Symbol("foo"), new Pair(new Pair(new Symbol("bar"), new Pair(new Number(1), Nil.getInstance())), Nil.getInstance()));
        assertEquals("(foo (bar 1))", list.toString());
    }
}
