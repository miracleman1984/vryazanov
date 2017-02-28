package tracker.start;

import org.junit.Test;
import tracker.models.Task;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for class StartUI with class StubInput and StubOutput.
 *
 * @author vryazanov
 * @version 1.0
 * @since 27.02.2017
 */
public class MenuTest {
    /**
     * If Pressed Wrong Key Then Message You have entered  not a key from the menu!.
     */
    @Test
    public void whenPressWrongKeyThenMessage() {
        final String[] answers = new String[]{"150", "7"};
        String[] expectedOutput = new String[]{"You have entered  not a key from the menu!"};
        Input input = new StubInput(answers);
        StubOutput output = new StubOutput();
        Tracker tracker = new Tracker();
        new StartUI(input, output).init(tracker);
        assertThat(output.getAnswers(), is(Arrays.asList(expectedOutput)));
    }

    /**
     * If there are no tasks in tracker then should work correctly.
     */
    @Test
    public void whenNoTasksThenNothingToDo() {
        final String[] answers = new String[]{"1", "3", "4", "7"};
        String[] expectedOutput = new String[]{
                "No items to show",
                "Nothing to edit",
                "Nothing to delete"};
        Input input = new StubInput(answers);
        StubOutput output = new StubOutput();
        Tracker tracker = new Tracker();
        new StartUI(input, output).init(tracker);
        assertThat(output.getAnswers(), is(Arrays.asList(expectedOutput)));
    }
    /**
     * Test main functional: add new item.
     */
    @Test
    public void whenAddNewItemThenItMustExists() {
        final String[] answers = new String[]{
                "2", "Problem", "Big big problem",
                "1",
                "7"};
        String[] expectedOutput = new String[]{
                "Name: Problem Description: Big big problem",
                };
        Input input = new StubInput(answers);
        StubOutput output = new StubOutput();
        Tracker tracker = new Tracker();
        new StartUI(input, output).init(tracker);
        assertThat(output.getAnswers(), is(Arrays.asList(expectedOutput)));
    }
    /**
     * Test main functional: add new item when no space for new item.
     */
    @Test
    public void whenAddNewItemAndThereIsNoSpaceThenMessage() {
        final String[] answers = new String[]{
                "2", "Problem", "Big big problem",
                "7"};
        String[] expectedOutput = new String[]{
                "Cant't add new item to tracker because no free elements in items"
        };
        Input input = new StubInput(answers);
        StubOutput output = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Task("1 task", "1 desc", "1"));
        tracker.add(new Task("2 task", "2 desc", "2"));
        tracker.add(new Task("3 task", "3 desc", "3"));
        tracker.add(new Task("4 task", "4 desc", "4"));
        tracker.add(new Task("5 task", "5 desc", "5"));
        tracker.add(new Task("6 task", "6 desc", "6"));
        tracker.add(new Task("7 task", "7 desc", "7"));
        tracker.add(new Task("8 task", "8 desc", "8"));
        tracker.add(new Task("9 task", "9 desc", "9"));
        tracker.add(new Task("10 task", "10 desc", "10"));
        new StartUI(input, output).init(tracker);
        assertThat(output.getAnswers(), is(Arrays.asList(expectedOutput)));
    }
    /**
     * Test main functional: delete existing item.
     */
    @Test
    public void whenDeleteExistingItemThenItMustBeDeleted() {
        final String[] answers = new String[]{
                "4",
                "1",
                "1",
                "7"};
        String[] expectedOutput = new String[]{
                "No items to show"
        };
        Input input = new StubInput(answers);
        StubOutput output = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Task("1 task", "1 desc", "1"));
        new StartUI(input, output).init(tracker);
        assertThat(output.getAnswers(), is(Arrays.asList(expectedOutput)));
    }
    /**
     * Test main functional: trying to delete non existing item.
     */
    @Test
    public void whenDeleteNonExistingItemThenMessage() {
        final String[] answers = new String[]{
                "4",
                "2",
                "7"};
        String[] expectedOutput = new String[]{
                "Nothing to delete"
        };
        Input input = new StubInput(answers);
        StubOutput output = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Task("1 task", "1 desc", "1"));
        new StartUI(input, output).init(tracker);
        assertThat(output.getAnswers(), is(Arrays.asList(expectedOutput)));
    }
    /**
     * Test main functional: edit existing item.
     */
    @Test
    public void whenEditItemThenItMustChanged() {
        final String[] answers = new String[]{
                "3", "1", "Small problem", "Not so big problem",
                "1",
                "7"};
        String[] expectedOutput = new String[]{
                "Name: Small problem Description: Not so big problem"};
        Input input = new StubInput(answers);
        StubOutput output = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Task("1 task", "1 desc", "1"));
        new StartUI(input, output).init(tracker);
        assertThat(output.getAnswers(), is(Arrays.asList(expectedOutput)));
    }
    /**
     * Test main functional: trying to edit nonexisting item.
     */
    @Test
    public void whenEditNonExistedItemThenMessage() {
        final String[] answers = new String[]{
                "3",
                "2",
                "7"};
        String[] expectedOutput = new String[]{
                "Nothing to edit"};
        Input input = new StubInput(answers);
        StubOutput output = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Task("1 task", "1 desc", "1"));
        new StartUI(input, output).init(tracker);
        assertThat(output.getAnswers(), is(Arrays.asList(expectedOutput)));
    }

    /**
     * Test adding finding by name and id we foung 2 items with the same name.
     */
    @Test
    public void whenNeedFindByNameThatExistsThenMustBeFound() {
        final String[] answers = new String[]{
                "5", "5 task",
                "7"};
        String[] expectedOutput = new String[]{
                "Name: 5 task Description: 5 desc",
                "Name: 5 task Description: 6 desc"};
        Input input = new StubInput(answers);
        StubOutput output = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Task("4 task", "4 desc", "4"));
        tracker.add(new Task("5 task", "5 desc", "5"));
        tracker.add(new Task("5 task", "6 desc", "6"));
        new StartUI(input, output).init(tracker);
        assertThat(output.getAnswers(), is(Arrays.asList(expectedOutput)));
    }
    /**
     * Test finding by name and trying to find item with name that we have not in the tracker.
     */
    @Test
    public void whenNeedFindByNameThatNotExistsThenNothingFound() {
        final String[] answers = new String[]{
                "5", "task",
                "7"};
        String[] expectedOutput = new String[]{
                "No items to show"};
        Input input = new StubInput(answers);
        StubOutput output = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Task("4 task", "4 desc", "4"));
        tracker.add(new Task("5 task", "5 desc", "5"));
        tracker.add(new Task("5 task", "6 desc", "6"));
        new StartUI(input, output).init(tracker);
        assertThat(output.getAnswers(), is(Arrays.asList(expectedOutput)));
    }
    /**
     * Test finding by id we search item with existed id.
     */
    @Test
    public void whenNeedFindByIDThatExistsThenHaveToBeFound() {
        final String[] answers = new String[]{
                "6", "5",
                "7"};
        String[] expectedOutput = new String[]{
                "Name: 5 task Description: 5 desc"};
        Input input = new StubInput(answers);
        StubOutput output = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Task("4 task", "4 desc", "4"));
        tracker.add(new Task("5 task", "5 desc", "5"));
        tracker.add(new Task("5 task", "6 desc", "6"));
        new StartUI(input, output).init(tracker);
        assertThat(output.getAnswers(), is(Arrays.asList(expectedOutput)));
    }
    /**
     * Test finding by id we search item with non existed id.
     */
    @Test
    public void whenNeedFindByIDThatNotExistsThenNothingFound() {
        final String[] answers = new String[]{
                "6", "20",
                "7"};
        String[] expectedOutput = new String[]{
                "No items to show"};
        Input input = new StubInput(answers);
        StubOutput output = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Task("4 task", "4 desc", "4"));
        tracker.add(new Task("5 task", "5 desc", "5"));
        tracker.add(new Task("5 task", "6 desc", "6"));
        new StartUI(input, output).init(tracker);
        assertThat(output.getAnswers(), is(Arrays.asList(expectedOutput)));
    }
}
