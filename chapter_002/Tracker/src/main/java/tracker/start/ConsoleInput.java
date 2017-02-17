package tracker.start;

import java.util.Scanner;

/**
 * Created by vr on 12.02.2017.
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    public String ask(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}