package ru.job4j.nonblockingalgoritm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by vvryazanov on 04.12.2017.
 */
public class NonBlock {


    private volatile boolean blockCustoner = true;

    public void doSomething() throws InterruptedException {

            while (this.blockCustoner) {
                System.out.println(String.format("%s wait", Thread.currentThread().getId()));
            }
    }


    public void changeBlock(boolean enable) {
            System.out.println(String.format("%s enable", Thread.currentThread().getId()));
            this.blockCustoner = enable;
    }

    private static volatile int count = 0;

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
            }
        }.start();

        List<String> syncList = Collections.synchronizedList(new ArrayList<String>());
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<String>();
        ConcurrentHashMap<String, String> stringStringConcurrentHashMap = new ConcurrentHashMap<String, String>();
    }
}
