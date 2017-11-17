package ru.job4j.threads;

/**
 * Created by vr on 17.08.2017.
 */
public class Time implements Runnable {
    public void run() {
        while ((System.currentTimeMillis() - ProgramStop.START_TIME) <= ProgramStop.TIMELIMIT) {
            int i = 1;
        }
    }
}
