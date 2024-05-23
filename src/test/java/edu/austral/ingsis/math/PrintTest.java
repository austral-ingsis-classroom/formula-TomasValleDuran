package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import edu.austral.ingsis.math.functions.*;
import edu.austral.ingsis.math.functions.Module;
import org.junit.Test;

import java.util.List;

public class PrintTest {

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    final String expected = "1 + 6";
    Function function = new Sum(List.of(
            new Number(1),
            new Number(6)
    ));
    final String result = function.print();

    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    final String expected = "12 / 2";
    Function function = new Division(new Number(12), new Number(2));
    final String result = function.print();

    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    final String expected = "(9 / 2) * 3";
    Function function = new Product(List.of(
            new Division(new Number(9), new Number(2)),
            new Number(3)
    ));
    final String result = function.print();

    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    final String expected = "(27 / 6) ^ 2";
    Function division = new Division(new Number(27), new Number(6));
    Function function = new Power(division, new Number(2));
    final String result = function.print();

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    final String expected = "|value| - 8";
    Function module = new Module(new Variable("value"));
    Function function = new Difference(List.of(
            module,
            new Number(8)
    ));
    final String result = function.print();

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction7() {
    final String expected = "|value| - 8";
    Function module = new Module(new Variable("value"));
    Function function = new Difference(List.of(
            module,
            new Number(8)
    ));
    final String result = function.print();

    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    final String expected = "(5 - i) * 8";
    Function difference = new Difference(List.of(
            new Number(5),
            new Variable("i")
    ));
    Function function = new Product(List.of(
            difference,
            new Number(8)
    ));
    final String result = function.print();

    assertThat(result, equalTo(expected));
  }
}
