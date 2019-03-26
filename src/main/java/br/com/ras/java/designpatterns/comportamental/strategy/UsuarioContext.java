package br.com.ras.java.designpatterns.comportamental.strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UsuarioContext {

  private final Map<Usuario.Tipo, UsuarioStrategy> strategys;
  private UsuarioStrategy strategySelected;

  public UsuarioContext(UsuarioStrategy strategy) {
    this();
    this.strategySelected = strategy;
  }

  public UsuarioContext() {
    this.strategySelected = null;
    this.strategys = new HashMap<Usuario.Tipo, UsuarioStrategy>(0);
    this.strategys.put(Usuario.Tipo.ADM, new AdministradorCadastro());
    this.strategys.put(Usuario.Tipo.VENDEDOR, new VendedorCadastro());
  }

  public void execute(final Usuario usuario) {
    if ( Objects.nonNull(strategySelected) ) {
      System.out.println("strategySelected: " + strategySelected.getClass().getSimpleName());
      strategySelected.realizarCadastro();
    } else {
      final UsuarioStrategy strategia = strategys.get(usuario.getTipo());
      if ( Objects.nonNull(strategia) ) {
        System.out.println("strategia: " + strategia.getClass().getSimpleName());
        strategia.realizarCadastro();
      }
      
      
    }
  }

}
