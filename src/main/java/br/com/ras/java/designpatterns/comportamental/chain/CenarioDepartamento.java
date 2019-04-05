package br.com.ras.java.designpatterns.comportamental.chain;

public class CenarioDepartamento extends CenarioChain {
  
  public CenarioDepartamento() {
    super(CadeiaEnum.DEPARTAMENTO);
  }

  @Override
  public Nivel verificar(int id) {
    System.out.println("verificar("+id+") :: Departamento");
    if (nivel != null && nivel.getId() == id) {
      return nivel;
    }
    return getNext().verificar(id);
  }
}
