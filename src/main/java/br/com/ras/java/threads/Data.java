package br.com.ras.java.threads;

import br.com.ras.java.shared.LogUtil;

public class Data extends LogUtil {
    private boolean outOfSync;
    private int value;

    public boolean isOutOfSync() {
        return outOfSync;
    }

    public void setOutOfSync(boolean outOfSync) {
        this.outOfSync = outOfSync;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public synchronized void sync() {
        outln("Synchronizing data...");

        try {
            if (!isOutOfSync())
                this.wait();

            setOutOfSync(false);
            Thread.sleep(5000);
            outln("Dados Sincronizados!");
            setValue(2021);

            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void read() {
        outln("---");
        outln("Realizando leitura dos dados...");

        try {
            if (outOfSync)
                this.wait();

            Thread.sleep(2000);

            outln("---");
            outln("Dados Sincronizados: " + getValue());
            outln("---");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}