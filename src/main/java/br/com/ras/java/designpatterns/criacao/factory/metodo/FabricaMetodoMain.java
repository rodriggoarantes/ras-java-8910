package br.com.ras.java.designpatterns.criacao.factory.metodo;

import br.com.ras.java.designpatterns.criacao.factory.metodo.MaquinaDeCafe.TipoDoCafe;

public class FabricaMetodoMain {
  
  public static void main(String[] args) {
    
    MaquinaDeBebidas maquina = null;
    Bebida bebida = null;
    
    System.out.println("-----------");
    System.out.println("Bebida CAFE");
    maquina = new MaquinaDeCafe();
    
    System.out.println( maquina.exibeMensagem() );
    bebida = maquina.entregaBebiba();
    System.out.println( bebida.info() );
    
    MaquinaDeCafe cafeteira = (MaquinaDeCafe) maquina;
    bebida = cafeteira.entregaBebiba(TipoDoCafe.COADO);
    System.out.println( bebida.info() );
    
    bebida = cafeteira.entregaBebiba(TipoDoCafe.EXPRESSO);
    System.out.println( bebida.info() );
    System.out.println("-----------");
    
    
    System.out.println("-----------");
    System.out.println("Bebida REFRIGERANTE");
    maquina = new MaquinaDeRefrigerante();
    System.out.println( maquina.exibeMensagem() );
    bebida = maquina.entregaBebiba();
    System.out.println( bebida.info() );
    System.out.println("-----------");
  }

}
