package kiwi.lang;

public class Parameter {
    protected Symbol name;
    protected boolean rest;

    public Parameter(Symbol name, boolean rest) {
        this.name = name;
        this.rest = rest;
    }

    public Symbol getName() {
        return name;
    }

    public boolean isRest() {
        return rest;
    }
}
