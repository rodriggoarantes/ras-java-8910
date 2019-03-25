package br.com.ras.java.designpatterns.criacao.factory.abstrata;

public class FabricaAbstrataMain {

  public static void main(String[] args) {
    
    FabricaDeCarros fabrica = null;
    
    
    System.out.println("-----------");
    System.out.println("Fabrica CHEVROLET");
    fabrica = new FabricaChevrolet();
    fabrica.criarSedan().exibirInfoSedan();
    System.out.println();
    fabrica.criarHatch().exibirInfoHatch();
    System.out.println("-----------");
    System.out.println();

    System.out.println("-----------");
    System.out.println("Fabrica FORD");
    fabrica = new FabricaFord();
    fabrica.criarSedan().exibirInfoSedan();
    System.out.println();
    fabrica.criarHatch().exibirInfoHatch();
    System.out.println("-----------");
  }
  
}
