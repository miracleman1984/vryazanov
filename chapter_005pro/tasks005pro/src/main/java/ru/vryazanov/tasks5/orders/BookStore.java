package ru.vryazanov.tasks5.orders;

import java.util.HashMap;

/**
 * Class  BookStore.
 * <p>
 * Contains books and methods to work this it.
 *
 * @author vryazanov
 * @version 1.0
 * @since 20.07.2017
 */
public class BookStore {
    /**
     * Store books with orders orders.
     */
    private HashMap<Integer, Book> bookStore = new HashMap<Integer, Book>();
    /**
     * Add order to the specific book and store.
     *
     * @param bookID specific book
     * @param operation to choose right store in the book
     * @param orderId unique id of the order
     * @param order to add
     */
    public void addOrder(int bookID, String operation, int orderId, Order order) {
        Book currentBook = this.getBook(bookID);
        currentBook.addType(orderId, operation);
        if ("BUY".equals(operation)) {
            currentBook.processBid(order);
        } else if ("SELL".equals(operation)) {
            currentBook.processAsk(order);
        }
    }
    /**
     * Get book from the bookstore.
     * If there is no book with such ID, create new book and add to the bookStore
     *
     * @param bookID specific book
     * @return specific book or new book if no such bookId int the store
     */
    public Book getBook(int bookID) {
        Book result = null;
        if (!bookStore.containsKey(bookID)) {
            result = new Book(bookID);
            bookStore.put(bookID, result);
        } else {
            result = bookStore.get(bookID);
        }
        return result;
    }
    /**
     * Delete order from the specific book.
     *
     * @param bookID specific book
     * @param orderID specific orderId
     */
    public void deleteOrder(int bookID, int orderID) {
        Book currentBook = this.getBook(bookID);
        String orderType = currentBook.getType(orderID);
        if ("BUY".equals(orderType)) {
            currentBook.deleteBid(new Order(orderID));
        } else if ("SELL".equals(orderType)) {
            currentBook.deleteAsk(new Order(orderID));
        }
    }
}
