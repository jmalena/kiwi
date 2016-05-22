package kiwi.lang;

import java.util.Objects;

public class Pair<E extends Expression> implements List<E> {
    protected E head;
    protected List<E> tail;

    public Pair(E head, List<E> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public String toString() {
        String tailString = "";
        
        if(!(getTail() instanceof Nil)) {
            tailString = getTail().toString();
            tailString = tailString.substring(1, tailString.length() - 1);
            tailString = " " + tailString;
        }
        
        return "(" + getHead() + tailString + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Pair)) {
            return false;
        }
        
        List<E> list1 = this;
        List<Expression> list2 = (Pair)obj;
        
        while(true) {
            if(list1 instanceof Nil && list2 instanceof Nil) {
                return true;
            } else if(list1 instanceof Nil && !(list2 instanceof Nil) || !(list1 instanceof Nil) && list2 instanceof Nil) {
                return false;
            } else if(!list1.getHead().equals(list2.getHead())) {
                return false;
            }
            
            list1 = list1.getTail();
            list2 = list2.getTail();
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(head);
        hash = 89 * hash + Objects.hashCode(tail);
        return hash;
    }

    @Override
    public E getHead() {
        return head;
    }

    @Override
    public List<E> getTail() {
        return tail;
    }

    @Override
    public Expression evaluate(Scope scope) throws RuntimeException {
        Callable fn = (Callable)getHead().evaluate(scope);
        return fn.call(scope, (List<Expression>)getTail());
    }
}
