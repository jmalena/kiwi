package test.kiwi.lang;

import org.junit.Test;
import static org.junit.Assert.*;
import kiwi.lang.Number;
import kiwi.lang.*;

public class PairEqualsTest {
    
    @Test
    public void testEqualsNull() {
        List<Number> list = new Pair(new Number(1), Nil.getInstance());
        
        assertFalse(list.equals(null));
    }
    
    @Test
    public void testEqualsSelf() {
        List<Number> list = new Pair(new Number(1), Nil.getInstance());
        
        assertTrue(list.equals(list));
    }
    
    @Test
    public void testEqualsDifferent() {
        List<Number> list1 = new Pair(new Number(1), Nil.getInstance());
        List<Number> list2 = new Pair(new Number(2), Nil.getInstance());
        List<Number> list3 = new Pair(new Number(1), new Pair(new Number(2), Nil.getInstance()));
        List<Nil> list4 = new Pair(Nil.getInstance(), Nil.getInstance());
        List<Nil> list5 = new Pair(Nil.getInstance(), new Pair(Nil.getInstance(), Nil.getInstance()));
        
        assertFalse(list1.equals(list2));
        assertFalse(list1.equals(list3));
        assertFalse(list3.equals(list1));
        assertFalse(list4.equals(list5));
        assertFalse(list5.equals(list4));
    }
    
    @Test
    public void testEqualsSame() {
        List<Number> list1 = new Pair(new Number(1), Nil.getInstance());
        List<Number> list2 = new Pair(new Number(1), Nil.getInstance());
        
        assertTrue(list1.equals(list2));
    }
}
