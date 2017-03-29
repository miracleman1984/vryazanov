package ru.vryazanov.hierachy;

import org.junit.Test;


import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by vr on 28.03.2017.
 */
public class HierarchyTest {
    /**
     * Test main functional: AscendingOrder.
     */
    @Test
    public void whenNeedAscendingOrderThenItIs() {
        List<String> input = new ArrayList<String>(Arrays.asList("K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2", "K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2", "K1\\SK1", "K1\\SK2",
                "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2", "K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"));
        List<String> answers = new ArrayList<String>(Arrays.asList("K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK2", "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"));
        Hierachy hierachy = new Hierachy();
        hierachy.init(input);
        List<String> result = hierachy.ascendingOrder();
        assertThat(result, is(answers));
    }

    /**
     * Test main functional: AscendingOrder.
     */
    @Test
    public void whenNeedDesceningOrderThenItIs() {
        List<String> input = new ArrayList<String>(Arrays.asList("K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2", "K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2", "K1\\SK1", "K1\\SK2",
                "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2", "K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"));
        List<String> answers = new ArrayList<String>(Arrays.asList("K2", "K2\\SK1", "K2\\SK1\\SSK2", "K2\\SK1\\SSK1", "K1", "K1\\SK2", "K1\\SK1", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1"));
        Hierachy hierachy = new Hierachy();
        hierachy.init(input);
        List<String> result = hierachy.desceningOrder();
        assertThat(result, is(answers));
    }
}
