package tracker.start;


import tracker.models.Item;
import tracker.models.Task;

import java.util.ArrayList;

/**
 * Created by vr on 12.02.2017.
 */
public class StartUI {
    private Input input;
    private Output output;

    public StartUI(Input input, Output output){
        this.input = input;
        this.output = output;
    }


    public void init(){
        Tracker tracker = new Tracker();
        System.out.println("This is a task tracker");
        Menu menu = new Menu(tracker);
        while(!menu.isExit) {
            if(menu.isShow) {
                menu.show();
            }
            menu.choise(input,output);
        }
    }

    public static void main (String[] args){
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();
        new StartUI(input, output).init();
    }
}
