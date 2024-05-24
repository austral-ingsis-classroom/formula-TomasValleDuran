package edu.austral.ingsis.math.functions;

import edu.austral.ingsis.math.Function;
import java.util.Map;
import java.util.Set;

public class Parenthesis implements Function {
  private final Function function;

  public Parenthesis(Function function) {
    this.function = function;
  }

  @Override
  public double evaluate(Map<String, Double> variables) {
    return function.evaluate(variables);
  }

  @Override
  public String print() {
    return "(" + function.print() + ")";
  }

  @Override
  public Set<String> listVariables() {
    return function.listVariables();
  }
}
