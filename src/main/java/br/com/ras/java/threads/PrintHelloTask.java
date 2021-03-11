package br.com.ras.java.threads;

import br.com.ras.java.shared.LogUtil;

public class PrintHelloTask extends LogUtil implements Runnable {
    private final String name;

    public PrintHelloTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        outln("Hello, " + name + "!");
    }

}
