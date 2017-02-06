package Tracker.start;

/**
 * Created by vr on 03.02.2017.
 */

import Tracker.models.*;

public class StartUI {
    public static void main (String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Task("first task", "first desc"));
        for (Item item : tracker.getAll()) {
            System.out.println(item.getName());
        }
        System.out.println(tracker.findByName("first task").getDescription());
        for (Item item : tracker.getAll()) {
            System.out.println(item.getName());
        }


        tracker.delete(new Task("first task", "first desc"));
        for (Item item : tracker.getAll()) {
            System.out.println(item.getName());
        }
    }
}
