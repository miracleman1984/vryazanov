package ru.job4j.jmm;

/**
 * Created by vr on 21.08.2017.
 */
public class First implements Runnable {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            SharedObject.sharedVar1++;
        }
    }
}
