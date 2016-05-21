package kiwi.lang;

public interface List<E extends Expression> extends Expression {
    public E getHead();
    public List getTail();
}
