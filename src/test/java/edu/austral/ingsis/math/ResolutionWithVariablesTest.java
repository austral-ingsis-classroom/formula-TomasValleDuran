package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.functions.*;
import edu.austral.ingsis.math.functions.Module;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    Function sum = new Sum(Arrays.asList(new Number(1), new Variable("x")));
    Map<String, Double> variables = new HashMap<>();
    variables.put("x", 3.0);
    Double result = sum.evaluate(variables);

    assertThat(result, equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    Function division = new Division(new Number(12), new Variable("div"));
    Map<String, Double> variables = new HashMap<>();
    variables.put("div", 4.0);
    Double result = division.evaluate(variables);

    assertThat(result, equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    Function product = new Product(Arrays.asList(new Division(new Number(9), new Variable("x")), new Variable("y")));
    Map<String, Double> variables = new HashMap<>();
    variables.put("x", 3.0);
    variables.put("y", 4.0);
    Double result = product.evaluate(variables);

    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    Function power = new Power(new Division(new Number(27), new Variable("a")), new Variable("b"));
    Map<String, Double> variables = new HashMap<>();
    variables.put("a", 9.0);
    variables.put("b", 3.0);
    Double result = power.evaluate(variables);

    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    Function sqrt = new Power(new Variable("z"), new Number(0.5));
    Map<String, Double> variables = new HashMap<>();
    variables.put("z", 36.0);
    Double result = sqrt.evaluate(variables);

    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    Function difference = new Difference(Arrays.asList(
            new Module(new Variable("value")),
            new Number(8)));
    Map<String, Double> variables = new HashMap<>();
    variables.put("value", 8.0);
    Double result = difference.evaluate(variables);

    assertThat(result, equalTo(0d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    Function difference = new Difference(Arrays.asList(
            new Module(new Variable("value")),
            new Number(8)));
    Map<String, Double> variables = new HashMap<>();
    variables.put("value", 8.0);
    Double result = difference.evaluate(variables);

    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    Function product = new Product(Arrays.asList(new Difference(Arrays.asList(new Number(5), new Variable("i"))), new Number(8)));
    Map<String, Double> variables = new HashMap<>();
    variables.put("i", 2.0);
    Double result = product.evaluate(variables);

    assertThat(result, equalTo(24d));
  }
}
