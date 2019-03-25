package br.com.ras.java.timestamp;

import java.util.Date;
import java.util.TimeZone;

public class TimestampMain {

  public static void main(String[] args) {
    System.out.println(" --------------------------------- ");
    testeTimeZone();
    System.out.println(" --------------------------------- ");
  }
  
  private static void testeTimeZone() {
    TimeZone time = TimeZone.getDefault();

    System.out.println("-> " + time.getID());
    System.out.println("-> " + time.getRawOffset());
    System.out.println("-> " + time.getID());

    try {
      String ver = System.getProperty("java.version");
      Date currentDate = new Date();
      System.out.println("JREion : " + ver);
      System.out.println(currentDate);
      // Default timezone from the system is used.
      TimeZone tz = TimeZone.getDefault();
      // Could manually set the timezone above. e.g :
      // TimeZone tz = TimeZone.getTimeZone("America/New_York");
      System.out.println("TimeZoneed : " + tz.getDisplayName(tz.inDaylightTime(currentDate),
        TimeZone.LONG));
      boolean indaylight = tz.inDaylightTime(currentDate);
      System.out.println("Youred time is " + (indaylight ? "in " : "not in ")
          + "daylight-savings time.");
    } catch (Exception e) {
      System.out.println("Errorutered. Please insure you supply a valid date format pattern.");
      System.out.println("Ensureve quotes placed around the pattern!");
      System.out.println("e.g DSTTest \"11/04/2007 1:00 AM\"");
    }
  }
  
  interface Calculadora {
    int soma(int param1, int param2);
  }

}
