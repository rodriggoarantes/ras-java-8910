package br.com.ras.java.script.nashorn;

import java.util.ArrayList;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavascriptMain {

  public static void main(String[] args) {
    System.out.println(" --------------------------------- ");
    testeScriptingDisponiveis();
    System.out.println(" --------------------------------- ");
    testeScriptingJava_formula_ifelse();
    System.out.println(" --------------------------------- ");
    testeScriptingJava_formula();
    System.out.println(" --------------------------------- ");
    testeScriptingJava_formula_simples();
    System.out.println(" --------------------------------- ");
    testeScriptingJava_formula_simples_retorno();
    System.out.println(" --------------------------------- ");
    testeScriptingJava_listaJava();
    System.out.println(" --------------------------------- ");
    testeScriptingJava_ObtendoParametros();
    System.out.println(" --------------------------------- ");
  }
  
  private static ScriptEngine getEngineJavascript() {
    final ScriptEngineManager mgr = new ScriptEngineManager();
    return mgr.getEngineByName("JavaScript");
  }
  
  //-----------------
  
  private static void testeScriptingDisponiveis() {
    ScriptEngineManager manager = new ScriptEngineManager();

    // Get the list of all available engines
    List<ScriptEngineFactory> list = manager.getEngineFactories();

    // Print the details of each engine
    for (ScriptEngineFactory f : list) {
      System.out.println("Engine Name:" + f.getEngineName());
      System.out.println("Engine Version:" + f.getEngineVersion());
      System.out.println("Language Name:" + f.getLanguageName());
      System.out.println("Language Version:" + f.getLanguageVersion());
      System.out.println("Engine Short Names:" + f.getNames());
      System.out.println("Mime Types:" + f.getMimeTypes());
      System.out.println("===");
    }
  }
  
  private static void testeScriptingJava_formula() {
    System.out.println("Executing in script environment...testeScriptingJava_formula");
    
    final StringBuilder script = new StringBuilder("");
    script.append(" var formula =  parseInt( ((x + y) - z) / a ); ");
    
    try {
      
      final ScriptEngine jsEngine = getEngineJavascript();
      jsEngine.put("x", 10);
      jsEngine.put("y", 11);
      jsEngine.put("z", 1);
      jsEngine.put("a", 2);
      
      jsEngine.eval(script.toString());
      
      System.out.println(" testeScriptingJava_formula -> " + jsEngine.get("formula"));
      
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  private static void testeScriptingJava_formula_simples() {
    System.out.println("Executing in script environment...testeScriptingJava_formula_simples");
    
    final StringBuilder script = new StringBuilder("");
    script.append(" ((x + y) - z) / a ");
    
    try {
      
      final ScriptEngine jsEngine = getEngineJavascript();
      jsEngine.put("x", 10);
      jsEngine.put("y", 11);
      jsEngine.put("z", 3);
      jsEngine.put("a", 2);
      
      final Double retorno = (Double) jsEngine.eval(script.toString());
      
      System.out.println(" testeScriptingJava_formula_simples -> " + retorno.intValue());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  private static void testeScriptingJava_formula_ifelse() {
    System.out.println("Executing in script environment...testeScriptingJava_formula_ifelse");
    
    final StringBuilder script = new StringBuilder("");
    script.append(" if ( x == 1 ) { ");
    script.append(" x ");
    script.append(" } else if (y == 2 ) { ");
    script.append(" y; ");
    script.append(" } else if (z == 3 ) { ");
    script.append(" z ");
    script.append(" } else { ");
    script.append(" 100; ");
    script.append(" } ");
    
    try {
      
      final ScriptEngine jsEngine = getEngineJavascript();
      jsEngine.put("x", 0);
      jsEngine.put("y", 0);
      jsEngine.put("z", 0);
      
      final Number retorno = (Number) jsEngine.eval(script.toString());
      
      System.out.println(" testeScriptingJava_formula_ifelse -> " + retorno.intValue());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  private static void testeScriptingJava_formula_simples_retorno() {
    System.out.println("Executing in script environment...testeScriptingJava_formula_simples_retorno");
    
    final StringBuilder script = new StringBuilder("");
    script.append(" var alpha = 100; ");
    script.append(" ( ((x + y) - z) / a ) + alpha ");
    
    try {
      
      final ScriptEngine jsEngine = getEngineJavascript();
      jsEngine.put("x", 40);
      jsEngine.put("y", 10);
      jsEngine.put("z", 30);
      jsEngine.put("a", 10);
      
      final Double retorno = (Double) jsEngine.eval(script.toString());
      
      System.out.println(" testeScriptingJava_formula_simples_retorno -> " + retorno.intValue());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  private static void testeScriptingJava_listaJava() {
    System.out.println("Executing in script environment...");
    
    final List<String> namesList = new ArrayList<String>(0);
    namesList.add("Jill");
    namesList.add("Bob");
    namesList.add("Laureen");
    namesList.add("Ed");

    final ScriptEngine jsEngine = getEngineJavascript();

    jsEngine.put("namesListKey", namesList);

    try {
      
      final StringBuilder script = new StringBuilder("");
      script.append(" var x; ");
      script.append(" var y; ");
      script.append(" var names = namesListKey.toArray(); ");
      script.append(" for(x in names)").append("  {  ");
      script.append(" print(names[x]); ").append("  }  ");
      script.append(" namesListKey.add(\"Dana\"); ");
      script.append("  ");
      
      jsEngine.eval(script.toString());
      
      
      System.out.println("Verificando lista apos o Script...");
      
      namesList.forEach(System.out::println);
      
    } catch (ScriptException ex) {
      ex.printStackTrace();
    }
  }
  
  private static void testeScriptingJava_ObtendoParametros() {
    System.out.println("Executing in script environment...testeScriptingJava_ObtendoParametros");
    
    final StringBuilder script = new StringBuilder("");
    script.append("  ");
    script.append(" var valorTotal = 0; ");
    script.append(" var obj = new Object(); ");
    script.append(" obj.soma = function(param1, param2) {return param1 + param2;}; ");
    script.append(" valorTotal = obj.soma(x, y); ");
    
    try {
      
      final ScriptEngine jsEngine = getEngineJavascript();
      jsEngine.put("x", 10);
      jsEngine.put("y", 11);
      
      jsEngine.eval(script.toString());
      
      final Object calc = jsEngine.get("obj"); 
      
      final Invocable inv = (Invocable) jsEngine;
      
      System.out.println(" -> " + jsEngine.get("valorTotal"));
      System.out.println(" -> " + inv.invokeMethod(calc, "soma", 12, 12));
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
