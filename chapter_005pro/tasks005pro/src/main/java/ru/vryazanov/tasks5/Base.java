package ru.vryazanov.tasks5;

/**
 * Class  Base.
 * <p>
 * Class as a base for our objects.
 *
 * @author vryazanov
 * @version 1.0
 * @since 10.04.2017
 */
public abstract class Base {
    /**
     * Store unique id for the item.
     */
    private String id;

    /**
     * Base constructor.
     *
     * @param id unique id for the item
     */
    public Base(String id) {

        this.id = id;
    }

    /**
     * Return id of the item.
     *
     * @return id of the item
     */
    String getId() {
        return id;
    }

    /**
     * Set id for the item.
     *
     * @param id for the item
     */
    void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        return this.id.equals(((Base) obj).getId());
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
