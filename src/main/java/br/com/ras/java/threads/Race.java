package br.com.ras.java.threads;

public class Race {
    private volatile boolean finished;

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
