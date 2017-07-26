package ru.vryazanov.tasks5.orders;

/**
 * Class  Order.
 * <p>
 * Contains information about specific order.
 *
 * @author vryazanov
 * @version 1.0
 * @since 20.07.2017
 */
public class Order {
    /**
     * Store unique id for the order.
     */
    private int orderId;
    /**
     * Store order price.
     */
    private double price;
    /**
     * Store order volume.
     */
    private int volume;
    /**
     * Order constructor.
     *
     * @param orderId unique id for the Order.
     * @param price order price.
     * @param volume order volume.
     */
    public Order(int orderId, double price, int volume) {
        this.orderId = orderId;
        this.price = price;
        this.volume = volume;
    }
    /**
     * Order constructor.
     * For dummy orders for searching purpose
     * used in operation deleteOrder
     *
     * @param orderId unique id for the Order.
     */
    public Order(int orderId) {
        this.orderId = orderId;
    }


    /**
     * Return order id.
     *
     * @return order id
     */
    public int getOrderId() {
        return orderId;
    }
    /**
     * Return order price.
     *
     * @return order price
     */
    public double getPrice() {
        return price;
    }
    /**
     * Return order volume.
     *
     * @return order volume
     */
    public int getVolume() {
        return volume;
    }
    /**
     * Set order volume.
     *
     * @param volume to set up
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Order{"
                + "orderId="
                + orderId
                + ", price="
                + price
                + ", volume="
                + volume
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Order order = (Order) o;

        return orderId == order.orderId;
    }
    @Override
    public int hashCode() {
        return orderId;
    }

}
