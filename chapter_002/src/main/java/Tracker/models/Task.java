package Tracker.models;

/**
 * Created by vr on 03.02.2017.
 */
public class Task extends Item {
    public Task(String name, String desc){
        this.name = name;
        this.description = desc;
    }

    public String calculatePrice(){
        return "100%";
    }
}
