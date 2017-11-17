package ru.job4j.waitnotifynotifyall;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class  ThreadPool.
 * <p>
 * Class that illustrates thread pool work.
 *
 * @author vryazanov
 * @version 1.0
 * @since 29.10.2017
 */
public class ThreadPool extends Thread {
//    1. Инициализация пула должна быть по количеству ядер в системе.
//    2. создать метод add(Work work).
//    3. Если есть свободные треды, начать выполнение работы. если нет. то в очередь до появления свободного треда.
    /**
     * Store number of cores in the a running system.
     */
    static final int CORES = Runtime.getRuntime().availableProcessors();
    /**
     * Store executing threads
     */
    private final Thread[] threads = new Thread[CORES];
    /**
     * Store queue of works
     */
    private final Queue<Work> works = new LinkedList<Work>();

    /**
     * ThreadPool constructor.
     */
    public ThreadPool() {
        this.setName("Thread Pool");
    }

    /**
     * Adding a work to working queue.
     *
     * @param work to be added
     */
    public void add(Work work) {
        synchronized (works) {
            works.add(work);
            works.notify();
        }
    }

    /**
     * Run method.
     */
    public void run() {
        while (!this.isInterrupted()) {
            synchronized (works) {
                while (works.isEmpty()) {
                    try {
                        //Если есть свободные треды, начать выполнение работы. если нет. то в очередь до появления свободного треда.
                        works.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (Thread t : threads) {
                    if (t == null || !t.isAlive()) {
                        t = new Thread(works.poll());
                        t.start();
                        break;
                    }
                }
            }
        }
    }

    /**
     * Main method.
     *
     * @param args args
     * @throws InterruptedException threads interruprion exeption
     */
    public static void main(String[] args) throws InterruptedException {
        ThreadPool pool = new ThreadPool();
        for (int i = 0; i < CORES * 2; i++) {
            pool.add(new Work("work " + i));
        }
        pool.start();
        for (int i = 0; i < CORES * 2; i++) {
            pool.add(new Work("work " + i));
            Thread.currentThread().sleep(500);
        }
    }


}
