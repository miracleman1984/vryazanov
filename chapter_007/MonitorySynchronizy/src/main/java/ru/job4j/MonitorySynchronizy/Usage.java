package ru.job4j.MonitorySynchronizy;

import jdk.nashorn.internal.runtime.OptimisticReturnFilters;

/**
 * Created by vr on 23.08.2017.
 */
public class Usage {
    public static final class Counter {
        long count = 0;
        final Object lock = new Object();
        static String name = "String";

        public synchronized void add(long value) {
            this.count += value;
        }

        public void sum(final Counter a, final Counter b) {
            synchronized (a) {
                synchronized (b) {
                    a.add(b.count);
                }
            }
        }


    }

    public static final class CounterThread extends Thread {
        protected final Counter counterA; //stack
        protected final Counter counterB; //stack

        public CounterThread(final Counter counterA, final Counter counterB) {
            this.counterA = counterA;
            this.counterB = counterB;
        }


        @Override
        public void run() {
            synchronized (this.counterA) {
                counterA.add(1);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i != 10; i++) {
            Counter counterA = new Counter(); //heap
            counterA.add(1);
            Counter counterB = new Counter(); //heap
            counterB.add(2);
            Thread threadA = new CounterThread(counterA, counterB); //heap
            Thread threadB = new CounterThread(counterB, counterA); //heap

            threadA.start();
            threadB.start();
            threadA.join();
            threadB.join();
            System.out.println(counterA.count); //heap
            System.out.println(counterB.count); //heap
        }
    }

}
