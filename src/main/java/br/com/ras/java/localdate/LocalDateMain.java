package br.com.ras.java.localdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateMain {

  public static void main(String[] args) {
    System.out.println(" ------------ ");
    hoje();
    System.out.println(" ------------ ");
    diaMesAno();
    System.out.println(" ------------ ");
    montarData();
    System.out.println(" ------------ ");
    compararDatas();
    System.out.println(" ------------ ");
    format();
    System.out.println(" ------------ ");
  }

  private static void hoje() {
    final LocalDate today = LocalDate.now();
    System.out.println("Today's Local date : " + today);
  }

  private static void diaMesAno() {
    LocalDate today = LocalDate.now();
    int year = today.getYear();
    int month = today.getMonthValue();
    int day = today.getDayOfMonth();
    System.out.printf("Year : %d Month : %d day : %d \t %n", year, month, day);
  }

  private static void montarData() {
    LocalDate dateOfBirth = LocalDate.of(1985, 3, 2);
    System.out.println("Data de aniversario : " + dateOfBirth);
  }

  private static void compararDatas() {
    final LocalDate today = LocalDate.now();
    final LocalDate dateOfBirth = LocalDate.of(1985, 3, 2);

    System.out.println("Data de HOJE : " + dateOfBirth);
    System.out.println("Data de BIRTH : " + dateOfBirth);

    if (!today.equals(dateOfBirth)) {
      System.out.println("As datas não são iguais");
    }

    if (today.isAfter(dateOfBirth)) {
      System.out.println("Hoje é apos a sua data de aniversario");
    }

    if (today.isBefore(today.plusDays(1))) {
      System.out.println("Hoje anterior ao amanha");
    }
  }

  private static void format() {
    String dayAfterTommorrow = "20140116";
    LocalDate formatted = LocalDate.parse(dayAfterTommorrow, DateTimeFormatter.BASIC_ISO_DATE);
    System.out.printf("Date generated from String %s is %s %n", dayAfterTommorrow, formatted);
    
    System.out.println(" ------------ ");
    final LocalDate today = LocalDate.now();
    System.out.printf("Date to String %s is %s", today, today.format(DateTimeFormatter.ISO_DATE));
    System.out.println("");
    
    System.out.println(" ------------ ");
    final DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a"); 
    
    final LocalDateTime agora = LocalDateTime.now();
    String dataFormatadaCustom = agora.format(format);
    System.out.printf("Data com Formato Customizado (%s) is (%s)", agora, dataFormatadaCustom);
    System.out.println("");
  }

}
