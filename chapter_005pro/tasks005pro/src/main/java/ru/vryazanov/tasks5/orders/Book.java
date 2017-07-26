package ru.vryazanov.tasks5.orders;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Map;

/**
 * Class  Book.
 * <p>
 * Contains information and methods to work this a book.
 *
 * @author vryazanov
 * @version 1.0
 * @since 20.07.2017
 */
public class Book {
    /**
     * Store unique id for the book.
     */
    private int bookId;
    /**
     * Store bid (buy) orders.
     */
    private TreeSet<Order> bids;
    /**
     * Store ask (sell) orders.
     */
    private TreeSet<Order> asks;
    /**
     * Store complience orderId to a order tyoe.
     */
    private HashMap<Integer, String> orderType = new HashMap<Integer, String>();

    /**
     * Book constructor.
     *
     * @param bookId unique id for the book.
     */
    public Book(int bookId) {
        this.bookId = bookId;
        bids = new TreeSet<Order>(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                int result;
                if (o1.getPrice() == o2.getPrice()) {
                    result = o1.getOrderId() - o2.getOrderId();
                } else if (o1.getPrice() == 0) {
                    result = 0;
                } else {
                    result = (int) ((o2.getPrice() - o1.getPrice()) * 100);
                }
                return result;
            }
        });
        asks = new TreeSet<Order>(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                int result;
                if (o1.getPrice() == o2.getPrice()) {
                    result = o1.getOrderId() - o2.getOrderId();
                } else if (o1.getPrice() == 0) {
                    result = 0;
                } else {
                    result = (int) ((o1.getPrice() - o2.getPrice()) * 100);
                }
                return result;
            }
        });

    }
    /**
     * Create new LinkedHashMap<Double, Integer> with summarize price duplicates  fromm source treeset.
     *
     * @param treeSet ource treeset
     * @return summarized map
     */
    private static LinkedHashMap<Double, Integer> sumTreeToMap(TreeSet<Order> treeSet) {
        LinkedHashMap<Double, Integer> result = new LinkedHashMap<Double, Integer>();
        double lastPrice = 0, currentPrice = 0;
        int lastVolume = 0, currentVolume = 0;
        for (Order order : treeSet) {
            currentPrice = order.getPrice();
            currentVolume = order.getVolume();
            if (currentPrice != lastPrice) {
                if (lastPrice != 0) {
                    result.put(lastPrice, lastVolume);
                }
                lastPrice = currentPrice;
                lastVolume = currentVolume;
            } else {
                lastVolume += currentVolume;
            }
        }
        if (lastPrice != 0) {
            result.put(lastPrice, lastVolume);
        }
        return result;
    }
    /**
     * Print book.
     *
     */
    public void print() {
        LinkedHashMap<Double, Integer> sumBids = sumTreeToMap(bids);
        LinkedHashMap<Double, Integer> sumAsks = sumTreeToMap(asks);
        Iterator bidsIterator = sumBids.entrySet().iterator();
        Iterator asksIterator = sumAsks.entrySet().iterator();
        //// Table begins ////
        System.out.println("Order book: " + this.getBookId());
        System.out.println("\tBid\t\t\t\tAsk\t");
        System.out.println("Volume@Price\tVolume@Price");
        while (bidsIterator.hasNext() || asksIterator.hasNext()) {
            String bidPart, askPart;
            if (bidsIterator.hasNext()) {
                Map.Entry bid = (Map.Entry) bidsIterator.next();
                bidPart = bid.getKey() + "@" + bid.getValue() + "\t";
            } else {
                bidPart = "\t ----------- \t";
            }
            if (asksIterator.hasNext()) {
                Map.Entry ask = (Map.Entry) asksIterator.next();
                askPart = "\t" + ask.getKey() + "@" + ask.getValue() + "\t";
            } else {
                askPart = "----------- \t";
            }
            System.out.println(askPart + bidPart);
        }
        //// End of table ////
    }

    /**
     * Add information about orderId:type to the compiliance table orderType.
     *
     * @param orderId to add
     * @param type to add
     */
    public void addType(int orderId, String type) {
        orderType.put(orderId, type);
    }

    /**
     * Process incoming bid (buy) order.
     *
     * @param bid incoming bid
     */
    public void processBid(Order bid) {
        if (asks.size() > 0) {
            Order oppositeAsk = asks.first();
            if (bid.getPrice() >= oppositeAsk.getPrice()) {
                //объем входящего больше объема существующего
                if (bid.getVolume() > oppositeAsk.getVolume()) {
                    //уменьшить объем входящего
                    bid.setVolume(bid.getVolume() - oppositeAsk.getVolume());
                    //удалить текущий
                    asks.remove(oppositeAsk);
                    //добавить входящий
                    bids.add(bid);
                } else if (bid.getVolume() == oppositeAsk.getVolume()) {
                    //объем входящего равен объему существующего
                    ////удалить текущий
                    asks.remove(oppositeAsk);
                } else if (bid.getVolume() < oppositeAsk.getVolume()) {
                    //объем входящего меньше объема  существующего
                    //уменьшить объем существующего
                    oppositeAsk.setVolume(oppositeAsk.getVolume() - bid.getVolume());
                }
            } else {
                bids.add(bid);
            }
        } else {
            bids.add(bid);
        }
    }
    /**
     * Process incoming ask (sell) order.
     *
     * @param ask incoming bid
     */
    public void processAsk(Order ask) {
        if (bids.size() > 0) {
            Order oppositeBid = bids.first();
            if (oppositeBid.getPrice() >= ask.getPrice()) {
                //объем входящего больше объема существующего
                if (ask.getVolume() > oppositeBid.getVolume()) {
                    //уменьшить объем входящего
                    ask.setVolume(ask.getVolume() - oppositeBid.getVolume());
                    //удалить текущий
                    bids.remove(oppositeBid);
                    //добавить входящий
                    asks.add(ask);
                } else if (oppositeBid.getVolume() == ask.getVolume()) {
                    //объем входящего равен объему существующего
                    ////удалить текущий
                    bids.remove(oppositeBid);
                } else if (ask.getVolume() < oppositeBid.getVolume()) {
                    //объем входящего меньше объема  существующего
                    //уменьшить объем существующего
                    oppositeBid.setVolume(oppositeBid.getVolume() - ask.getVolume());
                }
            } else {
                asks.add(ask);
            }
        } else {
            asks.add(ask);
        }
    }
    /**
     * Delete bid (buy)) order from the book by its orderID.
     *
     * @param bid to delete
     * @return result of the operation
     */
    public boolean deleteBid(Order bid) {
        return bids.remove(bid);
    }

    /**
     * Delete ask (sell)) order from the book by its orderID.
     *
     * @param ask to delete
     * @return result of the operation
     */
    public boolean deleteAsk(Order ask) {
        return asks.remove(ask);
    }
    /**
     * Return bid (buy) order by its orderId.
     *
     * @param orderId to search
     * @return bid (buy) order
     */
    public Order findBid(int orderId) {
        Order result = null;
        for (Order order : bids) {
            if (order.getOrderId() == orderId) {
                result = order;
            }
        }
        return result;
    }
    /**
     * Return ask (sell) order by its orderId.
     *
     * @param orderId to search
     * @return ask (sell) order
     */
    public Order findAsk(int orderId) {
        Order result = null;
        for (Order order : asks) {
            if (order.getOrderId() == orderId) {
                result = order;
            }
        }
        return result;
    }
    /**
     * Return order type by its orderId.
     *
     * @param orderID to search
     * @return type of the item
     */
    public String getType(int orderID) {
        return orderType.get(orderID);
    }
    /**
     * Return id of the book.
     *
     * @return id of the book
     */
    public int getBookId() {
        return bookId;
    }
    /**
     * Return bidStore.
     *
     * @return bidStore
     */
    public TreeSet<Order> getBids() {
        return bids;
    }
    /**
     * Return askStore.
     *
     * @return askStore
     */
    public TreeSet<Order> getAsks() {
        return asks;
    }
    /**
     * Return number of orders in the book.
     *
     * @return number of orders in the book
     */
    public int getSize() {
        return bids.size() + asks.size();
    }


}
