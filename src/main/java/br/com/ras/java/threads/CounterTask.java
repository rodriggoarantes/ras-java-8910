package br.com.ras.java.threads;

import br.com.ras.java.shared.LogUtil;

public class CounterTask extends LogUtil implements Runnable {
    private int counter;

    @Override
    public void run() {
        synchronized (this) {
            counter++;
            outln(Thread.currentThread().getName() + ": " + counter);
        }
    }
}
