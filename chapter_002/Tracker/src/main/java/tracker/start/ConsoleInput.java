package tracker.start;

import java.util.Scanner;

/**
 * ConsloleInput class show given message to System.out and return string with what a user type in.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 18.02.2017
 * @version 1
 */
public class ConsoleInput implements Input {
    /**
     * Store a class to catch what user type in.
     */
    private Scanner scanner = new Scanner(System.in);
    /**
     * Return next user input from keyboard.
     * @param message message to show to user to System.out
     * @return next user input from keyboard
     */
    public String ask(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}