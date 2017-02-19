package tracker.start;

import tracker.models.Item;
import tracker.models.Task;

import java.util.HashMap;

/**
 * Menu class includes menu and responces for each part of it.
 *
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @version 1
 * @since 18.02.2017
 */
public class Menu {
    /**
     * Store menu chapters.
     */
    private static final String[] MENU = {
            "1. Вывести список заявок",
            "2. Добавить новую заявку",
            "3. Отредактировать заявку",
            "4. Удалить заявку",
            "5. Найти заявку по названию.",
            "6. Найти заявку по номеру",
            "7. Выйти из программы."
    };
    /**
     * Store tracker on that menu operates.
     */
    private Tracker tracker;
    /**
     * Store is menu must be exit.
     */
    private boolean isExit = false;
    /**
     * Store is menu must be shown after this action.
     */
    private boolean isShow = true;

    /**
     * Menu class constructor.
     *
     * @param tracker on that menu operates
     */
    public Menu(Tracker tracker) {
        this.tracker = tracker;
    }

    /**
     * Show menu.
     */
    public void show() {
        System.out.println("What do your want? Press a number from menu:");
        for (String s : this.MENU) {
            System.out.println(s);
        }
    }

    /**
     * Create new item by given name and description.
     *
     * @param input from for it will be get
     * @return Item to add
     */
    public Item createItem(Input input) {
        String name = input.ask("Enter brief summary of item (name of item):  ");
        String description = input.ask("Enter your full story (description of item):  ");
        return new Task(name, description);
    }

    /**
     * Choose item from tracker.
     *
     * @param input from for it will be get
     * @param ask   question for user
     * @return Item chosen item
     */
    public Item chooseItem(Input input, String ask) {
        Item result = null;
        HashMap<Integer, String> map = tracker.enumItems();
        if (!map.isEmpty()) {
            result = tracker.findById(map.get(Integer.parseInt(input.ask(ask))));
        }
        return result;
    }

    /**
     * Choose item from tracker.
     *
     * @param input  from for it will be get
     * @param output to where will be shown important information
     */
    public void editItem(Input input, Output output) {
        Item itemForEdit = chooseItem(input, "Enter a number to choose item for edit");
        if (itemForEdit != null) {
            String id = itemForEdit.getId();
            String name = itemForEdit.getName();
            String description = itemForEdit.getDescription();
            System.out.println("You are edited task with id = " + id);
            System.out.println("name = " + name);
            String newName = input.ask("Enter new name or just press Enter to stay current");
            if (!"".equals(newName)) {
                name = newName;
            }
            System.out.println("description now = " + description);
            String newDescription = input.ask("Enter new description or just press Enter to stay current");
            if (!"".equals(newDescription)) {
                description = newDescription;
            }
            Item itemForUpdate = new Task(name, description);
            itemForUpdate.setId(id);
            tracker.update(itemForUpdate);
        } else {
            output.toOutput(new String[]{"Nothing to edit"});
        }
    }

    /**
     * Dialog for delete item from tracker.
     *
     * @param input  from for it will be get
     * @param output to where will be shown important information
     */
    public void deleteItem(Input input, Output output) {
        Item itemForDelete = chooseItem(input, "Enter a number to delete item");
        if (itemForDelete != null) {
            tracker.delete(chooseItem(input, "Enter a number to delete item"));
        } else {
            output.toOutput(new String[]{"Nothing to delete"});
        }
    }

    /**
     * Show given items to output.
     *
     * @param items  that must be shown
     * @param output to where will be shown important information
     */
    public void showItems(Item[] items, Output output) {
        if (items.length != 0 && items[0] != null) {
            for (Item item : items) {
                System.out.println("I'm here");
                output.toOutput(new String[]{"Name: " + item.getName() + " Description: " + item.getDescription()});
            }
        } else {
            output.toOutput(new String[]{"No items to show"});
        }
    }

    /**
     * Return is menu must be exit.
     *
     * @return is menu must be exit
     */
    public boolean isExit() {
        return isExit;
    }

    /**
     * Return is menu must be shown after this action.
     *
     * @return is menu must be shown after this actio
     */
    public boolean isShow() {
        return isShow;
    }

    /**
     * User choosing - do something.
     *
     * @param input  from for it will be get
     * @param output to where will be shown important information
     */
    public void choise(Input input, Output output) {
        switch (input.ask("Enter your choise:")) {
            case "1":
                showItems(tracker.getAll(), output);
                this.isShow = true;
                break;
            case "2":
                Item item = createItem(input);
                tracker.add(item);
                this.isShow = true;
                break;
            case "3":
                editItem(input, output);
                this.isShow = true;
                break;
            case "4":
                deleteItem(input, output);
                this.isShow = true;
                break;
            case "5":
                showItems(new Item[]{tracker.findByName(input.ask("Enter a name to find"))}, output);
                this.isShow = true;
                break;
            case "6":
                showItems(new Item[]{tracker.findById(input.ask("Enter an id to find"))}, output);
                isShow = true;
                break;
            case "7":
                this.isExit = true;
                break;
            default:
                output.toOutput(new String[]{"You have entered  not a key from the menu!"});
                this.isShow = false;
        }
    }
}
