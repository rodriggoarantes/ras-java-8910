package br.com.ras.java.designpatterns.comportamental.strategy.funcional;

public class FuncionalStrategyMain {

  public static double execute(double a, double b, Strategy strategy) {
    return strategy.apply(a, b);
  }

  public static void main(String[] args) {
    // a funcao lambda passada como parametro é a implementação da interface funcional Strategy
    System.out.println(execute(3, 4, (a, b) -> a > b ? a : b));
    System.out.println(execute(3, 4, (a, b) -> a < b ? a : b));
    System.out.println(execute(3, 4, (a, b) -> (a + b) / 2));
  }
}

@FunctionalInterface
interface Strategy {
  double apply(double a, double b);
}
