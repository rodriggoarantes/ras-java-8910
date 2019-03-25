package br.com.ras.java.designpatterns.estrutural.decorator;

public class DecoratorMain {
  
  public static void main(String[] args) {
    
    Pedido pizzaBase = new Pizza("Pizza Base da Casa", 10);
    pizzaBase = new CoberturaExtra("Mozzarella", 1, pizzaBase);
    
    // Pedido do cliente
    pizzaBase = new CoberturaExtra("Pepperoni", 4, pizzaBase);
    pizzaBase = new CoberturaExtraDupla("Calabreza", 6, pizzaBase);
    
    System.out.println(pizzaBase.getPreco());
    System.out.println(pizzaBase.getDescricao());
    
  }

}
