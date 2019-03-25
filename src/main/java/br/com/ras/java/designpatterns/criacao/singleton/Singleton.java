package br.com.ras.java.designpatterns.criacao.singleton;

public class Singleton {
  
  private static Singleton INSTANCE = null;
  
  private int id;
  private String nome;
  
  private Singleton() {}
  
  public static final Singleton getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new Singleton();
      INSTANCE.setId(100);
    }
    return INSTANCE;
  }

  public int getId() {
    return id;
  }

  private void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
