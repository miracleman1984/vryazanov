package ru.job4j.waitnotifynotifyall;

/**
 * Created by vvryazanov on 31.10.2017.
 */
public class ExecutorThread extends Thread {

    private Work currentWork;

    @Override
    public void run() {
        while(!isInterrupted()) {
            while (true) {
                try {
                    Thread.currentThread().wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
