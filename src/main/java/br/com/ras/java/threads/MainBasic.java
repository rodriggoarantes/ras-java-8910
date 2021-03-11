package br.com.ras.java.threads;

import br.com.ras.java.shared.LogUtil;

public class MainBasic extends LogUtil {
    public static void main(String [] args) {
        cenarioUm();
        cenarioDois();
        cenarioTres();
        cenarioQuatro();
    }


    private static void cenarioUm() {
        outln("-------- Cenario Um -----------");
        final var task1 = new Thread(new PrintHelloTask("Task 1"));
        final var task2 = new Thread(new PrintHelloTask("Task 2"));
        final var task3 = new Thread(new PrintHelloTask("Task 3"));
        final var task4 = new Thread(new PrintHelloTask("Task 4"));

        task1.start();
        task2.start();
        task3.start();
        task4.start();
    }

    private static void cenarioDois() {
        outln("-------- Cenario Dois -----------");
        final var task = new CounterTask();
        final var task1 = new Thread(task);
        final var task2 = new Thread(task);
        final var task3 = new Thread(task);
        final var task4 = new Thread(task);

        task1.start();
        task2.start();
        task3.start();
        task4.start();
    }


    /**
     * uso de threads com wait, num cenario de um sistema online e offline
     */
    private static void cenarioTres() {
        outln("-------- Cenario Tres -----------");

        final Data data = new Data();
        data.setOutOfSync(true);

        Thread readData = new Thread(new ReadDataThread(data));
        Thread syncData = new Thread(new SyncDataThread(data));

        readData.start();
        syncData.start();
    }

    /**
     * Controlando a finalizaçao de uma thread, um cenario entre corredores,
     * se um termina, o outro deve ser terminado, tendo apenas um vencedor
     */
    private static void cenarioQuatro() {
        Race race = new Race();
        Thread runner1 = new Thread(new Runner(race, "Runner 1"));
        Thread runner2 = new Thread(new Runner(race, "Runner 2"));
        Thread runner3 = new Thread(new Runner(race, "Runner 3"));

        outln("Starting...");
        runner1.start();
        runner2.start();
        runner3.start();
    }

}
