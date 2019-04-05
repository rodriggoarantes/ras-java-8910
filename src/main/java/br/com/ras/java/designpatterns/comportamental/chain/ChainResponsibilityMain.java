package br.com.ras.java.designpatterns.comportamental.chain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class ChainResponsibilityMain {

  public static void main(String[] args) {
    System.out.println("------------------");
    print( ordemManual() );
    System.out.println("------------------");
    // ordem do enum Fluxo - Produto > Secao > Departametno
    List<CadeiaEnum> listaCadeia = Arrays.asList(CadeiaEnum.values()); 
    print( cadeiaAutomatica(listaCadeia) );
    System.out.println("------------------");
    // ordem inversa Fluxo - D > S > P
    Collections.reverse(listaCadeia);
    print( cadeiaAutomatica(listaCadeia) );
  }
  
  
  private static void print(CenarioChain chain) {
    System.out.println("Resultado : " + chain.verificar(1).getDescricao()); // produto = 1
    System.out.println("Resultado : " + chain.verificar(2).getDescricao()); // Secao = 2
    System.out.println("Resultado : " + chain.verificar(3).getDescricao()); // Departamento = 3
    System.out.println("Resultado : " + chain.verificar(5)); // Nao existe
    System.out.println("Resultado : " + chain.verificar(0)); // Nao existe
  }
  
  private static CenarioChain ordemManual() {
    final CenarioCadeiaFactory factory = CenarioCadeiaFactory.getInstance();
    final CenarioChain nivel3 = factory.get(CadeiaEnum.DEPARTAMENTO);
    final CenarioChain nivel2 = factory.get(CadeiaEnum.SECAO);
    nivel2.setNext(nivel3);
    final CenarioChain nivel1 = factory.get(CadeiaEnum.PRODUTO);
    nivel1.setNext(nivel2);
    return nivel1;
  }
  
  private static CenarioChain cadeiaAutomatica(List<CadeiaEnum> cadeias) {
    final CenarioCadeiaFactory factory = CenarioCadeiaFactory.getInstance();
    if (cadeias != null && !cadeias.isEmpty()) {
      Iterator<CadeiaEnum> it = cadeias.iterator();
      CenarioChain chain = factory.get(it.next());
      while(it.hasNext()) {
        chain.setNext( factory.get(it.next()) );
      }
      return chain;
    }
    return null;
  }
}
