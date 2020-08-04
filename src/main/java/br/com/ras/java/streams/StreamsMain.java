package br.com.ras.java.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class StreamsMain {
  
  // Count the empty strings
  private static final List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");

  private static void reduceMethod() {

    final List<Integer> list = 
        IntStream.iterate(0, n -> n+1).limit(100).boxed().collect(Collectors.toList());    

    // Pipeline
    int soma = list.stream()
      .filter(i -> i % 2 == 1)
        .map(i -> i * 2)
          .reduce(0, (a, b) -> a + b);

    System.out.println("Soma = " + soma);
  }

  private static void estatistica() {
    // Get count, min, max, sum, and average for numbers
    List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
    IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();

    System.out.println("Highest prime number in List : " + stats.getMax());
    System.out.println("Lowest prime number in List : " + stats.getMin());
    System.out.println("Sum of all prime numbers : " + stats.getSum());
    System.out.println("Average of all prime numbers : " + stats.getAverage());
  }

  private static void removerDuplicatas() {
    // Create List of square of all distinct numbers
    List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
    List<Integer> distinct = numbers.stream().map(i -> i * i).distinct().collect(Collectors
      .toList());
    System.out.printf("Original List : %s, Square Without duplicates : %s %n", numbers, distinct);
  }
  
  private static void joining() {
    // Convert String to Uppercase and join them using coma
    List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
    String G7Countries = G7.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
    System.out.println(G7Countries);
  }
  
  private static void filterForList() {
    // Remove all empty Strings from List
    List<String> filtered = strList.stream().filter(x -> !x.isEmpty()).collect(Collectors.toList());
    System.out.printf("Original List : %s, List without Empty Strings : %s %n", strList, filtered);
    
    //  Create a List with String more than 2 characters
    filtered = strList.stream().filter(x -> x.length() > 2).collect(Collectors.toList());
    System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);
  }
  
  private static void contagem() {
    long count = strList.stream().filter(String::isEmpty).count();
    System.out.printf("List %s has %d empty strings %n", strList, count);

    // Count String with length more than 3
    long num = strList.stream().filter(x -> x.length() > 3).count();
    System.out.printf("List %s has %d strings of length more than 3 %n", strList, num);

    // Count number of String which startswith "a"
    count = strList.stream().filter(x -> x.startsWith("a")).count();
    System.out.printf("List %s has %d strings which startsWith 'a' %n", strList, count);
  }
  
  private static void fatorial() {
    final long iteracoes = 10;
    
    final long result = LongStream.iterate(1, n-> n+1)
                    .limit(iteracoes)                        
                      .reduce(1, (a,b) -> a * b);
     
    System.out.println("fatorial =  " + result);
  }

  private static void transformacao() {
    // to map
    List<String> list = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
    final Map<String, String> mapString = list.stream()
            .collect(Collectors.toMap(String::toString, periodo -> periodo));

    long count = mapString.size();
    System.out.printf("Map %s has %d strings %n", mapString, count);
  }

  public static void main(String[] args) {
    System.out.println(" ------------------------------------ ");
    contagem();
    System.out.println(" ------------------------------------ ");
    fatorial();
    System.out.println(" ------------------------------------ ");
    filterForList();
    System.out.println(" ------------------------------------ ");
    joining();
    System.out.println(" ------------------------------------ ");
    removerDuplicatas();
    System.out.println(" ------------------------------------ ");
    estatistica();
    System.out.println(" ------------------------------------ ");
    reduceMethod();
    System.out.println(" ------------------------------------ ");
    transformacao();
  }

}
