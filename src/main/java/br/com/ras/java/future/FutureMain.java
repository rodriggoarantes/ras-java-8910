package br.com.ras.java.future;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class FutureMain {
  
  private static final ExecutorService pool = Executors.newFixedThreadPool(10);
  private static final ExecutorService chachedPool = Executors.newCachedThreadPool();

  public static Callable<String> getData(final int index, final int time) {
      return () -> {
          Thread.sleep(time);
          return "TESTE-" + index;
      };
  }
  
  public static void main(String[] args) throws InterruptedException, ExecutionException {
      System.out.printf("chachedPool terminated %s%n", chachedPool.isTerminated());
      System.out.printf("terminated %s%n", pool.isTerminated());

      futureUnica();
      futureDupla();
      futureDupla_reverse();
      futureTriplaInversa();

      completableFeatureMany();

      completableFeature();

      pool.shutdown();
      System.out.printf("terminated %s%n", pool.isTerminated());
      System.out.printf("shut %s%n", pool.isShutdown());

      chachedPool.shutdown();
      System.out.printf("chachedPool terminated %s%n", chachedPool.isTerminated());
      System.out.printf("chachedPool shut %s%n", chachedPool.isShutdown());
  }
  
  
  private static void futureUnica() throws InterruptedException, ExecutionException {
    long start = System.nanoTime();
    
    Callable<String> c1 = getData(0, 3000);
    Future<String> f1 = pool.submit(c1);
    System.out.println(f1.get());
    long end = System.nanoTime();
    System.out.println("Tempo decorrido (segundos) = " + ((end - start)/1.0E9));
  }
  
  private static void futureDupla() throws InterruptedException, ExecutionException {
    long start = System.nanoTime();
    
    Callable<String> c1 = getData(1, 3000);
    Callable<String> c2 = getData(2, 5000);
    
    Future<String> f1 = pool.submit(c1);
    Future<String> f2 = pool.submit(c2);

    System.out.println(f1.get());
    System.out.println(f2.get());
    
    long end = System.nanoTime();
    
    System.out.println("Tempo decorrido (segundos) = " + ((end - start)/1.0E9));
  }
  
  private static void futureDupla_reverse() throws InterruptedException, ExecutionException {
    long start = System.nanoTime();
    
    Callable<String> c1 = getData(1, 3000);
    Callable<String> c2 = getData(2, 5000);
    
    Future<String> f1 = pool.submit(c1);
    Future<String> f2 = pool.submit(c2);

    // reverse
    System.out.println(f2.get());
    System.out.println(f1.get());
    
    long end = System.nanoTime();
    
    System.out.println("Tempo decorrido (segundos) = " + ((end - start)/1.0E9));
  }
  
  /**
   * O metodo executa a Future com maior duração primeiro, sendo que as demais com menor duração rodam em paralelo,
   * onde as de menor duração já estarão prontas quando a primeira de maior duração terminar, 
   * tendo o mesmo prazo de 10 segundos no total
   * 
   * @throws InterruptedException
   * @throws ExecutionException
   */
  private static void futureTriplaInversa() throws InterruptedException, ExecutionException {
    long start = System.nanoTime();
    
    Callable<String> c1 = getData(3, 5000);
    Callable<String> c2 = getData(4, 3000);
    Callable<String> c3 = getData(5, 2000);
    
    Future<String> f1 = pool.submit(c1);
    Future<String> f2 = pool.submit(c2);
    Future<String> f3 = pool.submit(c3);
    
    System.out.println(f1.get());
    System.out.println(f2.get());
    System.out.println(f3.get());
    
    long end = System.nanoTime();
    
    System.out.println("Tempo decorrido (segundos) = " + ((end - start)/1.0E9));
  }
  
  public static String getValor(final int index, final int time) {
      try {
          Thread.sleep(time);
      } catch (InterruptedException e) {
          return "TESTE-" + index + "-ERRO";
      }
    return "TESTE-" + index;
}
  
  private static void completableFeature() {
    System.out.println("Processors = " + Runtime.getRuntime().availableProcessors());
    
    final long start = System.nanoTime();
    final CompletableFuture<String> future = new CompletableFuture<>();

    CompletableFuture.runAsync(() -> future.complete(getValor(10, 6000)), pool);

    future.handle((content, ex) -> {
        if (ex == null) {
            System.out.println("content: " + content);
            long end = System.nanoTime();
            System.out.println("Tempo decorrido (segundos) = " + ((end - start) / 1.0E9));
        } else {
            ex.printStackTrace();
        }
        return null;
    });

    System.out.printf("Fim do metodos completableFeature %s%n", pool.isTerminated());
  }

    private static void completableFeatureMany() {
        final long start = System.nanoTime();

        IntStream.iterate(0, n -> n+1).limit(20).boxed()
                .forEach(numb -> {
                            final int key = 11 + numb;
                            CompletableFuture.runAsync(() -> getValor(key, 4000), chachedPool)
                                    .thenAccept(unused -> {
                                        long end = System.nanoTime();
                                        System.out.printf("[%d] Tempo decorrido (segundos) = %f %n", key, ((end - start) / 1.0E9));
                                    });
                        }
                );

        System.out.printf("Fim do metodos completableFeatureMany %s%n", pool.isTerminated());
    }
}
