package edu.austral.ingsis.math.functions;

import edu.austral.ingsis.math.Function;

import java.util.Map;
import java.util.Set;

public class Root implements Function {
    private final Function base;

    public Root(Function base) {
        this.base = base;
    }
    @Override
    public double evaluate(Map<String, Double> variables) {
        return Math.sqrt(base.evaluate(variables));
    }

    @Override
    public String print() {
        return "sqrt(" + base.print() + ")";
    }

    @Override
    public Set<String> listVariables() {
        return base.listVariables();
    }
}
