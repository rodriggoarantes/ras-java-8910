package br.com.ras.java.designpatterns.comportamental.chain;

public class CenarioProduto extends CenarioChain {
  
  public CenarioProduto() {
    super(CadeiaEnum.PRODUTO);
  }

  @Override
  public Nivel verificar(int id) {
    System.out.println("verificar("+id+") :: Produto");
    if (nivel != null && nivel.getId() == id) {
      return CadeiaEnum.PRODUTO;
    }
    return getNext().verificar(id);
  }
  
  
}
