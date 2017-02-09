package tracker.models;

/**
 * Item class that stores unique properties and methods for all items.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 06.02.2017
 * @version 1
 */
public class Item {
    /**
     * Store id of the item.
     */
    private String id;
    /**
     * Store id of the item.
     */
    private String name;
    /**
     * Store description full story of the item.
     */
    private String description;
    /**
     * Store create date in milliseconds.
     */
    private long create;
    /**
     * Store comment of the item.
     */
    private String comment;

    /**
     * Item class constructor.
     * @param name brief summary of item
     * @param description full story
     * @param create create date in milliseconds
     */
    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }
    /**
     * Return name of the item.
     * @return name of the item
     */
    public String getName() {
        return this.name;
    }
    /**
     * Return description of the item.
     * @return description of the item
     */
    public String getDescription() {
        return this.description;
    }
    /**
     * Return create date in milliseconds of the item.
     * @return create date in milliseconds of the item
     */
    public long getCreate() {
        return this.create;
    }
    /**
     * Return id of the item.
     * @return id of the item
     */
    public String getId() {
        return this.id;
    }
    /**
     * Set unique for the item.
     * @param id for the item
     */
    public void setId(String id) {
        this.id = id;
    }

}
