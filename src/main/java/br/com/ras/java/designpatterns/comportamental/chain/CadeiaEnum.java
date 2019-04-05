package br.com.ras.java.designpatterns.comportamental.chain;

public enum CadeiaEnum implements Nivel {
  
  PRODUTO,
  SECAO,
  DEPARTAMENTO
  ;

  @Override
  public int getId() {
    return this.ordinal() + 1;
  }

  @Override
  public String getDescricao() {
    return "Cadeia resolvida por " + this.name();
  }

}
