package br.com.ras.java.designpatterns.comportamental.chain;

public class CenarioSecao extends CenarioChain {
  
  public CenarioSecao() {
    super(CadeiaEnum.SECAO);
  }
  
  @Override
  public Nivel verificar(int id) {
    System.out.println("verificar("+id+") :: Secao");
    if (nivel != null && nivel.getId() == id) {
      return nivel;
    }
    return getNext().verificar(id);
  }
}
