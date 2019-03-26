package br.com.ras.java.designpatterns.comportamental.strategy;

public class Usuario {
  
  public enum Tipo { ADM, VENDEDOR, COMPRADOR };
  
  private int id;
  private String nome;
  private Tipo tipo;
  
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public Tipo getTipo() {
    return tipo;
  }
  public void setTipo(Tipo tipo) {
    this.tipo = tipo;
  }
}

