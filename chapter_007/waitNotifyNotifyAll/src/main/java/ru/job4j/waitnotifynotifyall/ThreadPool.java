package ru.job4j.waitnotifynotifyall;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class  ThreadPool.
 * <p>
 * Class that illustrates thread pool work.
 *
 * @author vryazanov
 * @version 2.0
 * @since 24.11.2017
 */
public class ThreadPool {
//    1. Инициализация пула должна быть по количеству ядер в системе.
//    2. создать метод
//    3. Если есть свободные треды, начать выполнение работы. если нет. то в очередь до появления свободного треда.
    /**
     * Store executing threads
     */
    private WorkerThread[] threads;
    /**
     * Store queue of works
     */
    private final BlockingQueue<Callable> works = new LinkedBlockingQueue<Callable>();
    /**
     * Store flag of shutting threads in the  pool down
     */
    private boolean isStopped = false;
    /**
     * Store locking object
     */
    final Object lock = new Object();

    /**
     * ThreadPool constructor.
     */
    public ThreadPool(int threadsNumber) {
        threads = new WorkerThread[threadsNumber];
        for (int i = 0; i < threadsNumber; i++) {
            threads[i] = new WorkerThread();
            threads[i].start();
        }
    }

    /**
     * Class  WorkerThread.
     * <p>
     * Thread woth work logic.
     * It starts, then poll work from query and execute it
     * If nothing to do  - it waits for signal
     * If there is a signal to stop thread then it stops.
     */
    private class WorkerThread extends Thread {
        /*
         * Store current thread work
         */
        private Callable currentWork;

        /**
         * Run method.
         */
        public void run() {
            //пока ему не сказали остановиться, он выполняет задачи из очереди+
            // если задач нет, он приостанавливается
            // если во время приостановки он получил сигнал о добавлении задачи, он пробуждается и выполняет ее
            while (!isStopped) {
                    while (works.isEmpty() && !isStopped) {
                        try {
                            synchronized (lock) {
                                System.out.println(Thread.currentThread().getName() + " waiting");
                                lock.wait();
                                System.out.println(Thread.currentThread().getName() + " no waiting");
                            }
                        } catch (InterruptedException e) {
                            System.out.println(e);
                        }
                    }

                currentWork = works.poll();
                if (currentWork != null) {
                    try {
                        currentWork.call();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
            System.out.println(Thread.currentThread().getName() + " is shutting down... ");

        }
    }

    /**
     * Set flag to stop the thread.
     */
    public void shutdownNow() {
        System.out.println("Starting shutdown");
        synchronized (lock) {
            isStopped = true;
            lock.notifyAll();
        }

    }

    /**
     * Adding a work to working queue.
     *
     * @param work to be added
     */
    public void add(Callable work) {
        System.out.println("Added new work! Notify All Threads!");
        works.add(work);
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    /**
     * Main method.
     *
     * @param args args
     * @throws InterruptedException threads interruprion exeption
     */
    public static void main(String[] args) throws InterruptedException {
        final Counter counter = new Counter();
        final int cores = Runtime.getRuntime().availableProcessors();
        ThreadPool pool = new ThreadPool(cores);

        for (int j = 0; j < cores ; j++) {
            pool.add(new Callable<String>() {
                public String call() throws InterruptedException {

                        counter.incremant();
                       return counter.toString();

                }
            });
        }
        Thread.currentThread().sleep(5000);
        for (int j = 0; j < cores ; j++) {
            pool.add(new Callable<String>() {
                public String call() throws InterruptedException {

                        counter.incremant();
                        return counter.toString();

                }
            });
        }
        Thread.currentThread().sleep(10000);
        pool.shutdownNow();
    }
}
