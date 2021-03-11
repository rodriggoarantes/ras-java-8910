package br.com.ras.java.threads;


import br.com.ras.java.shared.LogUtil;

public class ReadDataThread extends LogUtil implements Runnable {
    private final Data data;

    public ReadDataThread(Data data) {
        super();
        this.data = data;
    }

    @Override
    public void run() {
        outln("Antes de Realizar leitura dos dados: " + data.getValue());
        data.read();
    }
}
