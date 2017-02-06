package Tracker.models;

/**
 * Created by vr on 03.02.2017.
 */
public class Item {
    private String id;
    public String name;
    public String description;
    public long create;
    public String comment;

    public Item() {}
    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public long getCreate() {
        return this.create;
    }

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }

}
