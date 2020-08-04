package br.com.ras.java.shared;

import java.time.LocalDateTime;

public class LogUtil {
    protected static void out(String text) {
        System.out.print(text);
    }

    protected static void outln(String text) {
        System.out.println(text);
    }

    protected static void outTime(String text) {
        System.out.printf("%s :: %s%n", LocalDateTime.now(), text);
    }

    protected interface Executor {
        void execute();
    }
    protected static void executeTime(final Executor executor) {
        outTime("start");
        long inicio = System.currentTimeMillis();
        executor.execute();
        long fim = System.currentTimeMillis();
        long tempoDeExecucao = fim - inicio;
        System.out.printf("%nfinish time = %s ms%n", tempoDeExecucao);
    }
}
