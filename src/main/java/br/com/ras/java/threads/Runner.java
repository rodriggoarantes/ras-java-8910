package br.com.ras.java.threads;

import br.com.ras.java.shared.LogUtil;

public class Runner extends LogUtil implements Runnable {
    public Runner(Race race, String runner) {
        super();
        this.race = race;
        this.runner = runner;
    }

    public final Race race;
    public final String runner;

    @Override
    public void run() {
        outln(runner + " running...");
        while (!race.isFinished()) {
            race.setFinished(true);
            outln("Winner: " + runner);
            return;
        }
        outln(runner + " lost :(");
    }
}
