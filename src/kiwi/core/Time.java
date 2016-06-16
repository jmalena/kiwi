package kiwi.core;

import java.util.*;
import kiwi.lang.Number;
import kiwi.lang.Function;
import kiwi.lang.RuntimeException;
import kiwi.lang.*;

public class Time extends Function {

    @Override
    public ArrayList<Parameter> getParameters() {
        return new ArrayList<>();
    }

    @Override
    public Expression getResult(Scope callerScope, Scope calleeScope) throws RuntimeException {
        Calendar nye2016 = new GregorianCalendar(2016, Calendar.APRIL, 1);
        long secondsSinceNye2016 = nye2016.getTimeInMillis() / 1000;
        long secondsSinceNye1970 = System.currentTimeMillis() / 1000;
        return new Number(secondsSinceNye1970 - secondsSinceNye2016);
    }
}
