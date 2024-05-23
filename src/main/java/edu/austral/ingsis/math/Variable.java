package edu.austral.ingsis.math;

import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class Variable implements Function {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public double evaluate(Map<String, Double> variables) {
        return variables.get(name);
    }

    @Override
    public String print() {
        return name;
    }

    @Override
    public Set<String> listVariables() {
        return new HashSet<>(Collections.singleton(name));
    }
}
