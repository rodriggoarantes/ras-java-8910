package br.com.ras.java.designpatterns.comportamental.strategy;

public class VendedorCadastro implements UsuarioStrategy {

  @Override
  public void realizarCadastro() {
    System.out.println(" :: Vendedor Cadastrado :: ");
    System.out.println(" :: Vendedor Modulo de Vendas Liberado :: ");
  }
}
