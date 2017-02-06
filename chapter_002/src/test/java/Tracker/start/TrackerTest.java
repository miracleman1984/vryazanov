package Tracker.start;

import Tracker.models.Item;
import Tracker.models.Task;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by vr on 03.02.2017.
 */
public class TrackerTest {
    @Test
    public void whenAddNewItemThenItMustExist() {
        Tracker tracker = new Tracker();
        tracker.add(new Task("first task", "first desc"));
        String result = "";
        for (Item item : tracker.getAll()) {
           result = item.getName();
        }
        assertThat(result, is("first task"));
    }
    @Test
    public void whenUpdateExistedItemThenItMustBeUpdated() {
        String result = "";
        Tracker tracker = new Tracker();
        tracker.add(new Task("first task", "first desc"));
        Item updatedItem = new Task("updated task task", "updated desc");
        updatedItem.setId(tracker.getAll()[0].getId().toString());
        tracker.update(updatedItem);
        result = tracker.getAll()[0].getName().toString();
        assertThat(result, is("updated task task"));
    }
    @Test
    public void whenDeleteExistedItemThenItMustBeMinusOneItem() {
        int result = 10;
        Tracker tracker = new Tracker();
        Item itemForDelete = new Task("first task", "first desc");
        tracker.add(new Task("first task", "first desc"));
        itemForDelete.setId(tracker.getAll()[0].getId());
        tracker.delete(itemForDelete);
        result = tracker.getAll().length;
        assertThat(result, is(0));
    }
    @Test
    public void whenDeleteNonExistedItemThenItMustBeTheSameLength() {
        int result = 10;
        Tracker tracker = new Tracker();
        tracker.add(new Task("first task", "first desc"));
        Item itemForDelete = new Task("first task", "first desc");
        itemForDelete.setId("-5");
        tracker.delete(itemForDelete);
        result = tracker.getAll().length;
        assertThat(result, is(1));
    }

    @Test
    public void whenDeleteExistedInBigTrackerItemThenFindByNameAndSwitchItems() {
        int result = 10;
        Tracker tracker = new Tracker();
        tracker.add(new Task("first task", "first desc"));
        tracker.add(new Task("Second task", "Second desc"));
        tracker.add(new Task("Third task", "Third desc"));
        Item itemForDelete = new Task("first task", "first desc");
        itemForDelete.setId(tracker.findByName("first task").getId());
        System.out.println(tracker.getAll().length);
        tracker.delete(itemForDelete);
        result = tracker.getAll().length;
        assertThat(result, is(2));
    }

    @Test
    public void whenFindByIdAndExistsThenReturnNotNull() {
        Item result = null;
        Tracker tracker = new Tracker();
        tracker.add(new Task("first task", "first desc"));
        result = tracker.findById(tracker.getAll()[0].getId());
        assertThat(result.getName(), is("first task"));
    }
}