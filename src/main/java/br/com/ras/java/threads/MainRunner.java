package br.com.ras.java.threads;

import br.com.ras.java.shared.LogUtil;

public class MainRunner extends LogUtil {
    public static void main(String [] args) {
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
