package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.functions.*;
import edu.austral.ingsis.math.functions.Module;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    Function function = new Sum(List.of(
            new Number(1),
            new Number(6)
    ));
    final Double result = function.evaluate(Collections.emptyMap());

    assertThat(result, equalTo(7d));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    Function function = new Division(new Number(12), new Number(2));
    final Double result = function.evaluate(Collections.emptyMap());

    assertThat(result, equalTo(6d));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    Function function = new Product(List.of(
            new Division(new Number(9), new Number(2)),
            new Number(3)
    ));
    final Double result = function.evaluate(Collections.emptyMap());

    assertThat(result, equalTo(13.5d));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    Function division = new Division(new Number(27), new Number(6));
    Function function = new Power(division, new Number(2));
    final Double result = function.evaluate(Collections.emptyMap());

    assertThat(result, equalTo(20.25d));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    Function division = new Division(new Number(1), new Number(2));
    Function function = new Power(new Number(36), division);
    final Double result = 6d;

    assertThat(result, equalTo(6d));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    Function function = new Module(new Number(136));
    final Double result = function.evaluate(Collections.emptyMap());

    assertThat(result, equalTo(136d));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    Function function = new Module(new Number(-136));
    final Double result = function.evaluate(Collections.emptyMap());

    assertThat(result, equalTo(136d));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    Function difference = new Difference(List.of(
            new Number(5),
            new Number(5)
    ));
    Function function = new Product(List.of(
            difference,
            new Number(8)
    ));
    final Double result = function.evaluate(Collections.emptyMap());

    assertThat(result, equalTo(0d));
  }
}
