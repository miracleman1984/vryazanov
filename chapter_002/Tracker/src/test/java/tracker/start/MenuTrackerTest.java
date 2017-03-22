package tracker.start;

import org.junit.Test;
import tracker.models.Task;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for class StartUI with class ValidateStubInput and StubOutput.
 *
 * @author vryazanov
 * @version 1.0
 * @since 27.02.2017
 */
public class MenuTrackerTest {
    /**
     * If trying to enter non-existing number to choose in menu.
     */
    @Test
    public void whenEnterNonExistingNumberInMenuThenMessage() {
        final ArrayList<String> answers = new ArrayList<>(Arrays.asList("7", "2", "y"));
        String[] expectedOutput = new String[]{
                "Please select key from menu.",
                "No items to show"
        };
        Input input = new ValidateStubInput(answers);
        StubOutput output = new StubOutput();
        Tracker tracker = new Tracker();
        new StartUI(tracker, input, output).init();
        assertThat(output.getAnswers(), is(Arrays.asList(expectedOutput)));
    }
    /**
     * If trying to enter not a  number to choose in menu.
     */
    @Test
    public void whenEnterNotANumberInMenuThenMessage() {
        final ArrayList<String> answers = new ArrayList<>(Arrays.asList("y", "2", "y"));
        String[] expectedOutput = new String[]{
                "Please enter valid data again,",
                "No items to show"
        };
        Input input = new ValidateStubInput(answers);
        StubOutput output = new StubOutput();
        Tracker tracker = new Tracker();
        new StartUI(tracker, input, output).init();
        assertThat(output.getAnswers(), is(Arrays.asList(expectedOutput)));
    }
    /**
     * If there are no tasks in tracker then should work correctly.
     */
    @Test
    public void whenNoTasksThenNothingToDo() {
        final ArrayList<String> answers = new ArrayList<>(Arrays.asList("2", "n", "3", "n",  "4", "y"));
        String[] expectedOutput = new String[]{
                "No items to show",
                "Nothing to edit",
                "Nothing to delete"};
        Input input = new ValidateStubInput(answers);
        StubOutput output = new StubOutput();
        Tracker tracker = new Tracker();
        new StartUI(tracker, input, output).init();
        assertThat(output.getAnswers(), is(Arrays.asList(expectedOutput)));
    }
    /**
     * Test main functional: add new item.
     */
    @Test
    public void whenAddNewItemThenItMustExists() {
        final ArrayList<String> answers = new ArrayList<>(Arrays.asList(
                "1", "Problem", "Big big problem", "n",
                "2", "y"
        ));
        String[] expectedOutput = new String[]{
                "1. Problem"
                };
        Input input = new ValidateStubInput(answers);
        StubOutput output = new StubOutput();
        Tracker tracker = new Tracker();
        new StartUI(tracker, input, output).init();
        assertThat(output.getAnswers(), is(Arrays.asList(expectedOutput)));
    }
    /**
     * Test main functional: delete existing item.
     */
    @Test
    public void whenDeleteExistingItemThenItMustBeDeleted() {
        final ArrayList<String> answers = new ArrayList<>(Arrays.asList(
                "4", "1", "n",
                "2", "y"
        ));
        String[] expectedOutput = new String[]{
                "Successful deleting.",
                "No items to show"
        };
        Input input = new ValidateStubInput(answers);
        StubOutput output = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Task("1 task", "1 desc"));
        new StartUI(tracker, input, output).init();
        assertThat(output.getAnswers(), is(Arrays.asList(expectedOutput)));
    }
    /**
     * Test main functional: trying to delete non existing item.
     */
    @Test
    public void whenDeleteNonExistingItemThenMessage() {
        final ArrayList<String> answers = new ArrayList<>(Arrays.asList(
                "4", "5", "y"
        ));
        String[] expectedOutput = new String[]{
                "Some trouble with deleting, possible you've typed a wrong id."
        };
        Input input = new ValidateStubInput(answers);
        StubOutput output = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Task("1 task", "1 desc"));
        new StartUI(tracker, input, output).init();
        assertThat(output.getAnswers(), is(Arrays.asList(expectedOutput)));
    }
    /**
     * Test main functional: edit existing item.
     */
    @Test
    public void whenEditItemThenItMustChanged() {
        final ArrayList<String> answers = new ArrayList<>(Arrays.asList(
                "3", "1", "Small problem", "Not so big problem", "n",
                "2", "y"
        ));
        String[] expectedOutput = new String[]{
                "1. Small problem"};
        Input input = new ValidateStubInput(answers);
        StubOutput output = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Task("1 task", "1 desc"));
        new StartUI(tracker, input, output).init();
        assertThat(output.getAnswers(), is(Arrays.asList(expectedOutput)));
    }
    /**
     * Test main functional: trying to edit nonexisting item.
     */
    @Test
    public void whenEditNonExistedItemThenMessage() {
        final ArrayList<String> answers = new ArrayList<>(Arrays.asList(
                "3", "5", "y"
        ));
        String[] expectedOutput = new String[]{
                "Tracker have no task with such id."};
        Input input = new ValidateStubInput(answers);
        StubOutput output = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Task("1 task", "1 desc"));
        new StartUI(tracker, input, output).init();
        assertThat(output.getAnswers(), is(Arrays.asList(expectedOutput)));
    }

    /**
     * Test adding finding by name and id we foung 2 items with the same name.
     */
    @Test
    public void whenNeedFindByNameThatExistsThenMustBeFound() {
        final ArrayList<String> answers = new ArrayList<>(Arrays.asList(
                "5", "5 task", "y"
        ));
        String[] expectedOutput = new String[]{
                "2 item(s) has been found.",
                "2. 5 task",
                "3. 5 task"
        };
        Input input = new ValidateStubInput(answers);
        StubOutput output = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Task("4 task", "4 desc"));
        tracker.add(new Task("5 task", "5 desc"));
        tracker.add(new Task("5 task", "6 desc"));
        new StartUI(tracker, input, output).init();
        assertThat(output.getAnswers(), is(Arrays.asList(expectedOutput)));
    }
    /**
     * Test finding by name and trying to find item with name that we have not in the tracker.
     */
    @Test
    public void whenNeedFindByNameThatNotExistsThenNothingFound() {
        final ArrayList<String> answers = new ArrayList<>(Arrays.asList(
                "5", "task", "y"
        ));
        String[] expectedOutput = new String[]{
                "Nothing has been found."};
        Input input = new ValidateStubInput(answers);
        StubOutput output = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Task("4 task", "4 desc"));
        tracker.add(new Task("5 task", "5 desc"));
        tracker.add(new Task("5 task", "6 desc"));
        new StartUI(tracker, input, output).init();
        assertThat(output.getAnswers(), is(Arrays.asList(expectedOutput)));
    }
    /**
     * Test finding by id we search item with existed id.
     */
    @Test
    public void whenNeedFindByIDThatExistsThenHaveToBeFound() {
        final ArrayList<String> answers = new ArrayList<>(Arrays.asList(
                "6", "2", "y"
        ));
        String[] expectedOutput = new String[]{
                "2. 5 task"};
        Input input = new ValidateStubInput(answers);
        StubOutput output = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Task("4 task", "4 desc"));
        tracker.add(new Task("5 task", "5 desc"));
        tracker.add(new Task("5 task", "6 desc"));
        new StartUI(tracker, input, output).init();
        assertThat(output.getAnswers(), is(Arrays.asList(expectedOutput)));
    }
    /**
     * Test finding by id we search item with non existed id.
     */
    @Test
    public void whenNeedFindByIDThatNotExistsThenNothingFound() {
        final ArrayList<String> answers = new ArrayList<>(Arrays.asList(
                "6", "20", "y"
        ));
        String[] expectedOutput = new String[]{
                "Nothing has been found."};
        Input input = new ValidateStubInput(answers);
        StubOutput output = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Task("4 task", "4 desc"));
        tracker.add(new Task("5 task", "5 desc"));
        tracker.add(new Task("5 task", "6 desc"));
        new StartUI(tracker, input, output).init();
        assertThat(output.getAnswers(), is(Arrays.asList(expectedOutput)));
    }
}
