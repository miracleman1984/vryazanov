package tracker.start;

import tracker.models.Item;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Tracker class that stores items, its properties and methods for work with items.
 *
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @version 2
 * @since 28.02.2017
 */
public class Tracker {
    /**
     * Store items.
     */
    private ArrayList<Item> items = new ArrayList<Item>();
    /**
     * Store current last added id.
     */
    private String currentID = "0";
    /**
     * Store random number.
     */
    private static final Random RN = new Random();

    /**
     * Add item to database.
     *
     * @param item to add
     * @return result of operation true if ok otherwise false
     */
    public boolean add(Item item) {
        boolean result = false;
        if (item.getId() == null) {
            item.setId(this.generateID());
        }
        this.items.add(item);
        result = true;
        return result;
    }

    /**
     * Update item in database.
     *
     * @param itemFill to update
     */
    public void update(Item itemFill) {
        for (int i = 0; i < this.items.size(); i++) {
            Item item = this.items.get(i);
            if (item.getId().equals(itemFill.getId())) {
                this.items.set(i, itemFill);
                break;
            }
        }
    }

    /**
     * Delete item from database .
     *
     * @param item to delete
     * @return true if somethin has been removed fasle otherwise
     */
    public boolean delete(Item item) {
        boolean result = false;
        Iterator<Item> iterator = this.items.listIterator();
        while (iterator.hasNext()) {
            Item currentItem = iterator.next();
            if (currentItem.getId().equals(item.getId())) {
                iterator.remove();
                result = true;
                System.out.println("ok");
                break;
            }
        }
        return result;
    }

    /**
     * Find Item with definite name.
     *
     * @param name to find
     * @return list of item that was found
     */
    public ArrayList<Item> findByName(String name) {
        ArrayList<Item> resultList = new ArrayList<>();
        for (Item item : this.items) {
            if (item != null && item.getName().equals(name)) {
                resultList.add(item);
            }
        }
        return resultList;
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
        this.currentID = String.valueOf(Integer.parseInt(this.currentID) + 1);
        return this.currentID;
        //return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Returm all items from database.
     *
     * @return items from database
     */
    public ArrayList<Item> getAll() {
        ArrayList<Item> resultList = new ArrayList<>();
        for (Item item : this.items) {
            resultList.add(item);
        }
        return resultList;
    }
}
