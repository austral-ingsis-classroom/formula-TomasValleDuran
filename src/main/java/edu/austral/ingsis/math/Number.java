package edu.austral.ingsis.math;

import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class Number implements Function {
    private final double value;

    public Number(double value) {
        this.value = value;
    }

    @Override
    public double evaluate(Map<String, Double> variables) {
        return value;
    }

    @Override
    public String print() {
        return Double.toString(value);
    }

    @Override
    public Set<String> listVariables() {
        return new HashSet<>();
    }
}