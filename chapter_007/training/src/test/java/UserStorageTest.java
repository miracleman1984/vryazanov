import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by vr on 07.09.2017.
 */
public class UserStorageTest {
    /**
     * If incorrect transfer money should be error and no negative values on accounts.
     * @throws InterruptedException if thread will be stopped during its execution.
     */
    @Test
    public void whenIncorrectTransferMoneyShouldBeError() throws InterruptedException {
        final UserStorage stoge = new UserStorage();

        stoge.add(new User(1, 5));
        stoge.add(new User(2, 1));
        System.out.println(stoge.getUser(1).getAmount());
        System.out.println(stoge.getUser(2).getAmount());

        Runnable r = new Runnable() {
            public void run() {
                stoge.transfer(1, 2, 2);
            }
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        Thread t4 = new Thread(r);
        Thread t5 = new Thread(r);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        Thread.currentThread().sleep(5000);
        System.out.println(stoge.getUser(1).getAmount());
        System.out.println(stoge.getUser(2).getAmount());
        assertThat(stoge.getUser(1).getAmount(), is(1));
        assertThat(stoge.getUser(2).getAmount(), is(5));

    }

}