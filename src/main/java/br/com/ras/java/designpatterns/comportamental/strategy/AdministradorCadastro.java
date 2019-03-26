package br.com.ras.java.designpatterns.comportamental.strategy;

public class AdministradorCadastro implements UsuarioStrategy {

  @Override
  public void realizarCadastro() {
    System.out.println(" :: ADMINISTRADOR Cadastrado :: ");
    System.out.println(" :: ADMINISTRADOR SUPER SU :: ");
  }
}
