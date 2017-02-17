package tracker.start;

import tracker.models.Item;
import tracker.models.Task;

import java.util.HashMap;

/**
 * Created by vr on 16.02.2017.
 */
public class Menu {
    private Tracker tracker;

    public boolean isExit = false;
    public boolean isShow = true;

    final public String[] menu = {
            "1. Вывести список заявок",
            "2. Добавить новую заявку",
            "3. Отредактировать заявку",
            "4. Удалить заявку",
            "5. Найти заявку по названию.",
            "6. Найти заявку по номеру",
            "7. Выйти из программы."
    };

    public Menu(Tracker tracker) {
        this.tracker = tracker;
    }


    public void show(){
        System.out.println("What do your want? Press a number from menu:");
        for (String s:
             this.menu) {
            System.out.println(s);
        }
    }

    public Item createItem(Input input){
        String name = input.ask("Enter brief summary of item (name of item):  ");
        String description = input.ask("Enter your full story (description of item):  ");
        return new Task(name ,description);
    }

    public Item chooseItem(Input input, String ask){
        return tracker.findById(tracker.enumItems().get(Integer.parseInt(input.ask(ask))));
    }

    public void editItem(Input input, Output output){
        Item itemForEdit = chooseItem(input, "Enter a number to choose item for edit");
        String id = itemForEdit.getId();
        String name = itemForEdit.getName();
        String description = itemForEdit.getDescription();
        System.out.println("You are edited task with id = " + id);
        System.out.println("name = " + name);
        String new_name = input.ask("Enter new name or just press Enter to stay current");
        if(!"".equals(new_name)){
            name = new_name;
        }
        System.out.println("description now = " + description);
        String new_description= input.ask("Enter new description or just press Enter to stay current");
        if(!"".equals(new_description)){
            description = new_description;
        }
        Item itemForUpdate = new Task(name,description);
        itemForUpdate.setId(id);
        tracker.update(itemForUpdate);
    }

    public void deleteItem(Input input){
        tracker.delete(chooseItem(input, "Enter a number to delete item"));
    }

    public void showItems(Item[] items, Output output){
        for (Item item : items){
            output.toOutput(new String[] {"Name: " + item.getName() + " Description: " + item.getDescription()});
        }
    }

    public void choise(Input input, Output output){
        switch (input.ask("Enter your choise:"))
        {
            case "1":   {
                showItems(tracker.getAll(), output);
                this.isShow = true;
                break;
            }
            case "2":  {
                Item item = createItem(input);
                tracker.add(item);
                this.isShow = true;
                break;
            }
            case "3": {
                editItem(input, output);
                this.isShow = true;
                break;
            }
            case "4":  {
                deleteItem(input);
                this.isShow = true;
                break;
            }
            case "5":   {
                showItems(new Item[] {tracker.findByName(input.ask("Enter a name to find"))}, output);
                this.isShow = true;
                break;
            }
            case "6":   {
                showItems(new Item[] {tracker.findById(input.ask("Enter an id to find"))}, output);
                isShow = true;
                break;
            }
            case "7":   {
                this.isExit =true;
                break;}
            default: {
                output.toOutput(new String[]{"You have entered  not a key from the menu!"});
                this.isShow = false;
            }

        }
    }
}
