package br.com.ras.java.designpatterns.criacao.factory.metodo;

public abstract class MaquinaDeBebidas {
  
  public abstract Bebida entregaBebiba();
  
  public String exibeMensagem() {
            return "Bem-vindo à máquina de bebidas";
  }

}
