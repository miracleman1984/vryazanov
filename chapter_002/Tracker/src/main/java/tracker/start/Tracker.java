package tracker.start;

import tracker.models.Item;

import java.util.HashMap;
import java.util.Random;

/**
 * Tracker class that stores items, its properties and methods for work with items.
 *
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @version 1
 * @since 06.02.2017
 */
public class Tracker {
    /**
     * Store items.
     */
    private Item[] items = new Item[10];
    /**
     * Store current position in items.
     */
    private int position = 0;
    /**
     * Store random number.
     */
    private static final Random RN = new Random();

    /**
     * Add item to database.
     *
     * @param item to add
     */
    public void add(Item item) {
        item.setId(this.generateID());
        this.items[position++] = item;
    }

    /**
     * Update item in database.
     *
     * @param itemFill to update
     */
    public void update(Item itemFill) {
        for (int index = 0; index != this.position; index++) {
            if (this.items[index] != null && this.items[index].getId().equals(itemFill.getId())) {
                this.items[index] = itemFill;
                break;
            }
        }
    }

    /**
     * Delete item from database .
     *
     * @param item to delete
     */
    public void delete(Item item) {
        for (int index = 0; index != this.position; index++) {
            if (this.items[index] != null && this.items[index].getId().equals(item.getId())) {
                if (index != this.position - 1) {
                    this.items[index] = this.items[this.position - 1];
                } else {
                    this.items[index] = null;
                }
                this.position--;
                break;
            }
        }
    }

    /**
     * Find Item with definite name.
     *
     * @param name to find
     * @return list of item that was found
     */
    public Item findByName(String name) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getName().equals(name)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Find Item with definite id.
     *
     * @param id to find
     * @return item that was found
     */
    protected Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Generate id for current item.
     *
     * @return id to set to the item
     */
    String generateID() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Returm all items from database.
     *
     * @return items from database
     */
    public Item[] getAll() {
        Item[] result = new Item[position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }
    /**
     * Enumerate items in database from 1 to database size.
     *
     * @return enumerated items from database - pairs: number - id
     */
    public HashMap<Integer, String> enumItems() {
        int count = 0;
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        for (Item item : getAll()) {
            count++;
            map.put(count, item.getId());
            System.out.println(count + ".  " + item.getName() + "  id =  " + item.getId());
        }
        return map;
    }
}
