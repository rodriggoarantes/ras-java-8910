package br.com.ras.java.designpatterns.criacao.singleton;

public class SingletonMain {
  
  public static void main(String[] args) {
    
    final Singleton singletonObj = Singleton.getInstance();
    singletonObj.setNome("Rodrigo");
    
    System.out.println("Singleton UID : " + singletonObj.getId());
    System.out.println("Singleton NOME : " + singletonObj.getNome());
    
    final Singleton ref2 = Singleton.getInstance();
    ref2.setNome("Arantes");
    
    System.out.println("Singleton UID [2]: " + ref2.getId());
    System.out.println("Singleton NOME [2]: " + ref2.getNome());
    System.out.println("Singleton NOME [singletonObj]: " + singletonObj.getNome());
  }
}
