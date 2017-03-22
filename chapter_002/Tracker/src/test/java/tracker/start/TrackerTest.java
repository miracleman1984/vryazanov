package tracker.start;

import tracker.models.Item;
import tracker.models.Task;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tracker test.
 *
 * @author vryazanov
 * @version 1
 * @since 25.01.2016
 */
public class TrackerTest {
    /**
     * Adding one item and check that it exists.
     */
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

    /**
     * Update one item and check that it was updated.
     */
    @Test
    public void whenUpdateExistedItemThenItMustBeUpdated() {
        String result = "";
        Tracker tracker = new Tracker();
        tracker.add(new Task("first task", "first desc"));
        Item updatedItem = new Task("updated first task", "updated desc");
        updatedItem.setId(tracker.getAll().get(0).getId().toString());
        tracker.update(updatedItem);
        result = tracker.getAll().get(0).getName().toString();
        assertThat(result, is("updated first task"));
    }

    /**
     * Delete one item and check that it was deleted.
     */
    @Test
    public void whenDeleteExistedItemThenItMustBeMinusOneItem() {
        int result = 10;
        Tracker tracker = new Tracker();
        Item itemForDelete = new Task("first task", "first desc");
        tracker.add(new Task("first task", "first desc"));
        itemForDelete.setId(tracker.getAll().get(0).getId());
        tracker.delete(itemForDelete);
        result = tracker.getAll().size();
        assertThat(result, is(0));
    }

    /**
     * Trying to delete non-existed item and check that nothing was happened this items.
     */
    @Test
    public void whenDeleteNonExistedItemThenItMustBeTheSameLength() {
        int result = 10;
        Tracker tracker = new Tracker();
        tracker.add(new Task("first task", "first desc"));
        Item itemForDelete = new Task("first task", "first desc");
        itemForDelete.setId("-5");
        tracker.delete(itemForDelete);
        result = tracker.getAll().size();
        assertThat(result, is(1));
    }

    /**
     * Trying to delete existed item in the beginning of the list and check that elements was switched.
     * We use find by name to check it.
     */
    @Test
    public void whenDeleteExistedInBigTrackerItemThenFindByNameAndSwitchItems() {
        int result = 10;
        Tracker tracker = new Tracker();
        tracker.add(new Task("first task", "first desc"));
        tracker.add(new Task("Second task", "Second desc"));
        tracker.add(new Task("Third task", "Third desc"));
        Item itemForDelete = new Task("first task", "first desc");
        itemForDelete.setId(tracker.findByName("first task").get(0).getId());
        tracker.delete(itemForDelete);
        result = tracker.getAll().size();
        assertThat(result, is(2));
    }

    /**
     * Trying to find existed item by name and check that elements was finded correctly.
     */
    @Test
    public void whenFindByIdAndExistsThenReturnNotNull() {
        Item result = null;
        Tracker tracker = new Tracker();
        tracker.add(new Task("first task", "first desc"));
        result = tracker.findById(tracker.getAll().get(0).getId());
        assertThat(result.getName(), is("first task"));
    }
}