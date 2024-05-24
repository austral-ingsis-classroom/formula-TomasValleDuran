package edu.austral.ingsis.math;

import java.util.Map;
import java.util.Set;

public interface Function {
  public double evaluate(Map<String, Double> variables);

  public String print();

  public Set<String> listVariables();
}
