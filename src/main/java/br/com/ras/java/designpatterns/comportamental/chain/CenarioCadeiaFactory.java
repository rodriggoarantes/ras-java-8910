package br.com.ras.java.designpatterns.comportamental.chain;

public final class CenarioCadeiaFactory {
  
  private CenarioCadeiaFactory() {}
  
  public final static CenarioCadeiaFactory get() {
    return new CenarioCadeiaFactory();
  }
  
  public final CenarioChain of(CadeiaEnum tipo) {
    final CenarioChain chain;
    switch (tipo) {
      case SECAO: chain = new CenarioSecao(); break;
      case DEPARTAMENTO: chain = new CenarioDepartamento(); break;
      default: chain = new CenarioProduto();
    }
    return chain;
  }

}
