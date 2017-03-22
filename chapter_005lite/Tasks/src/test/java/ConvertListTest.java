import org.junit.Test;


import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for class  ConvertList.
 *
 * @author vryazanov
 * @version 1.0
 * @since 27.02.2017
 */
public class ConvertListTest {
    /**
     * If converts massive to list.
     */
    @Test
    public void whenConvertMassiveToListThenMustBeConverted() {
        int[][] source = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        List<Integer> expectedOutput = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 0, 0);
        List<Integer> answers = new ConvertList().toList(source);
        assertThat(answers, is(expectedOutput));
    }

    /**
     * If converts list to massive with definite dimentions. Amount of elements in List is less than in massive
     */
    @Test
    public void whenConvertListMassiveThatLessThenFillOtherCellsZero() {
        List<Integer> source = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        int[][] expectedOutput = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        int[][] answers = new ConvertList().toArray(source, 3);
        assertThat(answers, is(expectedOutput));
    }

    /**
     * If converts list to massive with definite dimentions. Amount of elements in List is greater than in massive
     */
    @Test
    public void whenConvertListMassiveWithMoreAmountElementsThenCutOtherElements() {
        List<Integer> source = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        int[][] expectedOutput = new int[][]{{1, 2}, {3, 4}};
        int[][] answers = new ConvertList().toArray(source, 2);
        assertThat(answers, is(expectedOutput));
    }
}
