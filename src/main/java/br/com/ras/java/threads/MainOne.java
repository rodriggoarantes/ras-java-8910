package br.com.ras.java.threads;

public class MainOne {
    public static void main(String [] args) {
        final var task1 = new Thread(new PrintHelloTask("Task 1"));
        final var task2 = new Thread(new PrintHelloTask("Task 2"));
        final var task3 = new Thread(new PrintHelloTask("Task 3"));
        final var task4 = new Thread(new PrintHelloTask("Task 4"));

        task1.start();
        task2.start();
        task3.start();
        task4.start();
    }
}
