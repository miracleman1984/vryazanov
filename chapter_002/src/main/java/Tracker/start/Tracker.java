package Tracker.start;

/**
 * Created by vr on 03.02.2017.
 */

import Tracker.models.*;
import java.util.*;
import java.lang.*;

public class Tracker {
    private Item[] items = new Item[10];
    private int position = 0;
    private static final Random RN = new Random();

    public Item add(Item item){
        item.setId(this.generateID());
        this.items[position++] = item;
        return item;
    }

    public void update(Item itemFill){
        for (int index = 0; index != this.position; index++){
            if (this.items[index]!= null && this.items[index].getId().equals(itemFill.getId())) {
                this.items[index] = itemFill;
                break;
            }
        }
    }

    public void delete(Item item){
        for (int index = 0; index != this.position; index++){
            if (this.items[index]!= null && this.items[index].getId().equals(item.getId())) {
                if (index != this.position - 1){
                    this.items[index] = this.items[this.position-1];
                } else {
                    this.items[index] = null;
                }
                this.position--;
                break;
            }
        }
    }


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
    String generateID(){
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    public Item[] getAll() {
        Item[] result = new Item[position];
        for (int index = 0; index != this.position; index++){
            result[index] = this.items[index];
        }
        return result;
    }
}
