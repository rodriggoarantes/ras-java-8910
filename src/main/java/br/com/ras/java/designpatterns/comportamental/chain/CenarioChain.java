package br.com.ras.java.designpatterns.comportamental.chain;

public abstract class CenarioChain {

  private CenarioChain next;
  protected final Nivel nivel;
  
  protected CenarioChain(Nivel nivel) {
    this.nivel = nivel;
  }
  
  public void setNext(CenarioChain pNext) {
    if (next == null) {
      this.next = pNext;
    } else {
      next.setNext(pNext);
    }
  }
  
  protected CenarioChain getNext() {
    if (next == null) {
      return new CenarioChain(null) {
        @Override
        public Nivel verificar(int id) {
          return this.nivel;
        }
      };
    } else {
      return next;
    }
  }
  
  public abstract Nivel verificar(int id);
}
