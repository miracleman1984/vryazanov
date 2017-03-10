package tracker.start;

import tracker.models.Item;
import tracker.models.Task;


/**
 * EditItem class menu chapter for editing incoming item.
 *
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @version 1
 * @since 07.03.2017
 */
class EditItem extends BaseAction  {
    /**
     *EditItem class constructor.
     *
     * @param name  set decription for the action
     */
    EditItem(String name) {
        super(name);
    }

    @Override
    public int key() {
        return 3;
    }

    @Override
    public void execute(Input input, Output output, Tracker tracker) {
        Item[] foundItems = tracker.getAll();
        if (foundItems.length == 0) {
            output.toOutput("Nothing to edit");
        } else {
            String id = input.ask("Please,enter the task's id: ");
            if (tracker.findById(id) != null) {
                String name = input.ask("Please,enter the task's name: ");
                String desc = input.ask("Please,enter the task's desc: ");
                Task task = new Task(name, desc);
                task.setId(id);
                tracker.update(task);
            } else {
                output.toOutput("Tracker have no task with such id.");
            }
        }
    }
}
/**
 * MenuTracker class includes menu and responces for each part of it.
 *
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @version 1
 * @since 07.03.2017
 */
public class MenuTracker {
    /**
     * Store current input.
     */
    private Input input;
    /**
     * Store current output.
     */
    private Output output;
    /**
     * Store tracker on that menu operates.
     */
    private Tracker tracker;
    /**
     * Store menu actions.
     */
    private UserAction[] actions = new UserAction[6];
    /**
     * Store current menu position in actions.
     */
    private int position = 0;
    /**
     * MenuTracker class constructor.
     *
     * @param input  set input method
     * @param output set output method
     * @param tracker set current tracker
     */
    public MenuTracker(Input input, Output output, Tracker tracker) {
        this.input = input;
        this.output = output;
        this.tracker = tracker;
    }
    /**
     * Fill actions storage.
     */
    public void fillActions() {
        this.actions[position++] = this.new AddItem("Add the new item");
        this.actions[position++] = new MenuTracker.ShowItems("Show all items");
        this.actions[position++] = new EditItem("Edit the item");
        this.actions[position++] = new DeleteItem("Delete item by id");
        this.actions[position++] = new FindItemByName("Find item by name");
        this.actions[position++] = new FindItemByID("Find item by id");
    }
    /**
     * Add new action to the menu.
     *
     * @param action new menu action
     */
    public void addAction(UserAction action) {
        this.actions[position++] = action;
    }
    /**
     * Return range for menu chapter numbers.
     *
     * @return range with existing menu chapter numbers
     */
    public int[] getRange() {
        //test for null objects
        int[] temp = new int[actions.length];
        int i = 0;
        for (UserAction userAction : actions) {
            if (userAction != null) {
                temp[i] = userAction.key();
                i++;
            }
        }
        int[] result = new int[i];
        int k = 0;
        for (int j : temp) {
            result[k++] = j;
        }
        return result;
    }

    /**
     * Execute selected menu chapter.
     *
     * @param key selected menu chapter
     */
    public void select(int key) {

        this.actions[key - 1].execute(this.input, this.output, this.tracker);
    }
    /**
     * Show actions from storage.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
    /**
     *  AddItem class menu chapter for adding item to current storage.
     *
     * @author Vitaly Ryazanov miracleman@mail.ru
     * @version 1
     * @since 07.03.2017
     */
    private class AddItem extends BaseAction {
        /**
         * AddItem class constructor.
         *
         * @param name  set decription for the action
         */
        AddItem(String name) {
            super(name);
        }
        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Output output, Tracker tracker) {
            String name = input.ask("Please,enter the task's name: ");
            String desc = input.ask("Please,enter the task's desc: ");
            if (!tracker.add(new Task(name, desc))) {
                output.toOutput("Cant't add new item to tracker because no free elements in items");
            }
        }
    }
    /**
     *  DeleteItem class menu chapter for deleting item from current storage.
     *
     * @author Vitaly Ryazanov miracleman@mail.ru
     * @version 1
     * @since 07.03.2017
     */
    private class DeleteItem extends BaseAction {
        /**
         * DeleteItem class constructor.
         *
         * @param name  set decription for the action
         */
        DeleteItem(String name) {
            super(name);
        }
        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Output output, Tracker tracker) {
            Item[] foundItems = tracker.getAll();
            if (foundItems.length == 0) {
                output.toOutput("Nothing to delete");
            } else {
                String id = input.ask("Please,enter the task's id: ");
                Task task = new Task("anything", "anything");
                task.setId(id);
                if (!tracker.delete(task)) {
                    output.toOutput("Some trouble with deleting, possible you've typed a wrong id.");
                } else {
                    output.toOutput("Successful deleting.");
                }
            }
        }
    }
    /**
     *  FindItemByName class menu chapter for finding items from current storage by name.
     *
     * @author Vitaly Ryazanov miracleman@mail.ru
     * @version 1
     * @since 07.03.2017
     */
    private class FindItemByName extends BaseAction {
        /**
         * FindItemByName class constructor.
         *
         * @param name  set decription for the action
         */
        FindItemByName(String name) {
            super(name);
        }

        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Output output, Tracker tracker) {
            String name = input.ask("Please,enter the task's name to find: ");
            Item[] foundItems = tracker.findByName(name);
            if (foundItems.length == 0) {
                output.toOutput("Nothing has been found.");
            } else {
                output.toOutput(String.format("%s item(s) has been found.", foundItems.length));
                for (Item item : foundItems) {
                    output.toOutput(String.format("%s. %s", item.getId(), item.getName()));
                }
            }
        }
    }
    /**
     *  FindItemByID class menu chapter for finding item from current storage by id.
     *
     * @author Vitaly Ryazanov miracleman@mail.ru
     * @version 1
     * @since 07.03.2017
     */
    private class FindItemByID extends BaseAction {
        /**
         * FindItemByID class constructor.
         *
         * @param name  set decription for the action
         */
        FindItemByID(String name) {
            super(name);
        }

        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Output output, Tracker tracker) {
            String id = input.ask("Please,enter the task's id to find: ");
            Item foundItem = tracker.findById(id);
            if (foundItem == null) {
                output.toOutput("Nothing has been found.");
            } else {
                output.toOutput(String.format("%s. %s", foundItem.getId(), foundItem.getName()));
            }
        }
    }
    /**
     *  ShowItems class menu chapter for showing items from current storage.
     *
     * @author Vitaly Ryazanov miracleman@mail.ru
     * @version 1
     * @since 07.03.2017
     */
    private static class ShowItems extends BaseAction {
        /**
         * ShowItems class constructor.
         *
         * @param name  set decription for the action
         */
        ShowItems(String name) {
            super(name);
        }

        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Output output, Tracker tracker) {
            Item[] foundItems = tracker.getAll();
            if (foundItems.length == 0) {
                output.toOutput("No items to show");
            } else {
                for (Item item : foundItems) {
                    output.toOutput(String.format("%s. %s", item.getId(), item.getName()));
                }
            }
        }
    }
}
