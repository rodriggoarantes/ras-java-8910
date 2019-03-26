package br.com.ras.java.designpatterns.comportamental.strategy;

public class StrategyMain {
  
  public static void main(String[] args) {
    //   estratagia automatica
    UsuarioContext contexto = new UsuarioContext();
    
    Usuario administrador = new Usuario();
    administrador.setTipo(Usuario.Tipo.ADM);
    administrador.setNome("ADM");
    
    contexto.execute(administrador);
    
    Usuario vendedor = new Usuario();
    vendedor.setTipo(Usuario.Tipo.VENDEDOR);
    vendedor.setNome("vendedor");
    
    contexto.execute(vendedor);
    
    // contexto definido
    UsuarioContext tornarAdministrador = new UsuarioContext(new AdministradorCadastro());
    tornarAdministrador.execute(new Usuario());
  }
  

}
