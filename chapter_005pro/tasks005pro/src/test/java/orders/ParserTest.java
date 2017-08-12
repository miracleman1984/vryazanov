package orders;

import org.junit.Test;
import ru.vryazanov.tasks5.orders.BookStore;
import ru.vryazanov.tasks5.orders.Parser;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test for class  Parser.
 *
 * @author vryazanov
 * @version 1.0
 * @since 20.07.2017
 */
public class ParserTest {
    /**
     * No deal if Buy order are lower than Sell order.
     */
    @Test
    public void whenBuyIsLowerSellThenNoDeal() {
        String fileName = "no_deal1.xml";
        BookStore bookStore = new BookStore();
        Parser parser = new Parser(fileName, bookStore);
        parser.start();
        assertThat(bookStore.getBook(1).getAsks().size(), is(1));
        assertThat(bookStore.getBook(1).getBids().size(), is(1));
    }

    /**
     * No deal if Sell orders are greate than Buy order.
     */
    @Test
    public void whenSellIsLowerBuyThenNoDeal() {
        String fileName = "no_deal2.xml";
        BookStore bookStore = new BookStore();
        Parser parser = new Parser(fileName, bookStore);
        parser.start();
        assertThat(bookStore.getBook(1).getAsks().size(), is(1));
        assertThat(bookStore.getBook(1).getBids().size(), is(1));
    }

    /**
     * No deal if Sell orders are greate than Buy order.
     */
    @Test
    public void whenSellIsGreaterBuyThenDeal() {
        String fileName = "dealSellWithBuy.xml";
        BookStore bookStore = new BookStore();
        Parser parser = new Parser(fileName, bookStore);
        parser.start();
        assertThat(bookStore.getBook(1).getAsks().size(), is(0));
        assertThat(bookStore.getBook(1).getBids().size(), is(3));
        assertThat(bookStore.getBook(1).findBid(3).getVolume(), is(5));
    }

    /**
     * If Buy Is Less than Sells And Volume Buy Is Greater Then Deal.
     */
    @Test
    public void whenPriceBuyIsLessSellAndVolumeBuyIsGreaterThenDeal() {
        String fileName = "dealBuyWithSellBuy.xml";
        BookStore bookStore = new BookStore();
        Parser parser = new Parser(fileName, bookStore);
        parser.start();
        assertThat(bookStore.getBook(1).getAsks().size(), is(2));
        assertThat(bookStore.getBook(1).getBids().size(), is(1));
        assertThat(bookStore.getBook(1).findBid(1).getVolume(), is(14));
    }

    /**
     * If Equal Price Sell Then Deal With First.
     */
    @Test
    public void whenEqualPriceSellThenDealWithFirst() {
        String fileName = "EqualSellPrice.xml";
        BookStore bookStore = new BookStore();
        Parser parser = new Parser(fileName, bookStore);
        parser.start();
        assertThat(bookStore.getBook(1).getAsks().size(), is(2));
        assertThat(bookStore.getBook(1).getBids().size(), is(1));
        assertThat(bookStore.getBook(1).findBid(1).getVolume(), is(50));
    }

    /**
     * If Equal Price Buy Then Deal With First.
     */
    @Test
    public void whenEqualPriceBuyThenDealWithFirst() {
        String fileName = "EqualBuyPrice.xml";
        BookStore bookStore = new BookStore();
        Parser parser = new Parser(fileName, bookStore);
        parser.start();
        assertThat(bookStore.getBook(1).getAsks().size(), is(0));
        assertThat(bookStore.getBook(1).getBids().size(), is(2));
    }

    /**
     * If delete order new size should deacrease to 1.
     */
    @Test
    public void whenDeleteOrderThenSizeMinusOne() {
        String fileName = "whenDeleteOrderThenSizeMinusOne.xml";
        BookStore bookStore = new BookStore();
        Parser parser = new Parser(fileName, bookStore);
        parser.start();
        assertThat(bookStore.getBook(2).getAsks().size(), is(1));
    }

    /**
     * Summarized print test.
     */
    @Test
    public void whenPrintShouldSummarize() {
        String fileName = "EqualSellPrice.xml";
        BookStore bookStore = new BookStore();
        Parser parser = new Parser(fileName, bookStore);
        parser.start();
        bookStore.getBook(1).print();
    }

    /**
     * If two books should working correctly.
     */
    @Test
    public void whenDifferentBooksAndPreviousTwoTest() {
        String fileName = "EqualBuyPrice.xml";
        BookStore bookStore = new BookStore();
        Parser parser = new Parser(fileName, bookStore);
        parser.start();
        System.out.println(bookStore.getBook(1));
        System.out.println(bookStore.getBook(2));
        assertThat(bookStore.getBook(1).getAsks().size(), is(0));
        assertThat(bookStore.getBook(1).getBids().size(), is(2));
        assertThat(bookStore.getBook(2).getAsks().size(), is(2));
        assertThat(bookStore.getBook(2).getBids().size(), is(1));
        assertThat(bookStore.getBook(2).findBid(1).getVolume(), is(50));
    }

    /**
     * Time of processing big file.
     */
    @Test
    public void speedTest() {
        String fileName = "orders.xml";
        BookStore bookStore = new BookStore();
        Parser parser = new Parser(fileName, bookStore);
        long time0 = System.currentTimeMillis();
        parser.start();
        System.out.println((System.currentTimeMillis() - time0) / 1000. + "  c.");
    }
}
