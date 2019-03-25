package br.com.ras.java.designpatterns.estrutural.decorator;

public class Pizza implements Pedido {
  private String descricao;
  private double preco;
  
  public Pizza(String descricao, double preco) {
    this.descricao = descricao;
    this.preco = preco;
  }

  @Override
  public double getPreco() {
    return preco;
  }

  @Override
  public String getDescricao() {
    return descricao;
  }

}
