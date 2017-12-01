package ru.job4j.waitnotifynotifyall;

/**
 * Created by vvryazanov on 26.11.2017.
 */
public class SharedObject {
    final MyLock l = new MyLock();
    private String var = "nothing";

    public String getVar() {
        return var;
    }

    public void setVar(String var) throws InterruptedException {
        System.out.println(l);
        System.out.println(Thread.currentThread().getName() + " inside lock");
        System.out.println("Setting var to " + var);
        this.var = var;
        System.out.println(Thread.currentThread().getName() + " starting to wait 1s.");
        Thread.currentThread().sleep(1000);
        System.out.println(Thread.currentThread().getName() + " waiting is over.");
    }

}
