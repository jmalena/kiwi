package kiwi.lang;

public class Number implements Expression {
    protected double value;

    public Number(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Number)) {
            return false;
        }
        
        Number number = (Number)obj;
        return getValue() == number.getValue();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int) (Double.doubleToLongBits(value) ^ (Double.doubleToLongBits(value) >>> 32));
        return hash;
    }

    @Override
    public Expression evaluate(Scope scope) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
