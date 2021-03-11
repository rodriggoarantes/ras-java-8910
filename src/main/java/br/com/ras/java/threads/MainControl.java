package br.com.ras.java.threads;

import br.com.ras.java.shared.LogUtil;

public class MainControl extends LogUtil {

    /**
     * uso de threads com wait, num cenario de um sistema online e offline
     */
    public static void main(String [] args) {
        outln("-------- Cenario Tres -----------");

        final Data data = new Data();
        data.setOutOfSync(true);

        Thread readData = new Thread(new ReadDataThread(data));
        Thread syncData = new Thread(new SyncDataThread(data));

        readData.start();
        syncData.start();
    }
}
