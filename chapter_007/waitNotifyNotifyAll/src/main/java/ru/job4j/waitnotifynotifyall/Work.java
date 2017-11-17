package ru.job4j.waitnotifynotifyall;

/**
 * Class  Work.
 * <p>
 * Class contains a work to execute.
 *
 * @author vryazanov
 * @version 1.0
 * @since 29.10.2017
 */
public class Work implements Runnable {
    /**
     * Store work name.
     */
    private String name;

    /**
     * Work constructor.
     *
     * @param name work name
     */
    public Work(String name) {
        this.name = name;
    }

    /**
     * Run method.
     */
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is executing " + name + " work.");
        System.out.println(Thread.currentThread().getName() + " is finished " + name + " work.");
    }
}
