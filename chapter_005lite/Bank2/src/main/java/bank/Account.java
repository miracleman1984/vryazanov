package bank;

/**
 * Account class that stores unique properties and methods for all accounts.
 *
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @version 1
 * @since 26.03.2017
 */
public class Account {
    /**
     * Store requisites of the account.
     */
    private long requisites;
    /**
     * Store value  of money on the account.
     */
    private long value;
    /**
     * Account class constructor.
     *
     * @param requisites  of the account
     * @param value of money on the account.
     */
    public Account(long requisites, long value) {
        this.requisites = requisites;
        this.value = value;
    }
    /**
     * Return requisites of the account.
     *
     * @return requisites of the account.
     */
    public long getRequisites() {
        return requisites;
    }
    /**
     * Return value of money on the account.
     *
     * @return value of money on the account.
     */
    public long getValue() {
        return value;
    }
    /**
     * Set value of money on the account.
     *
     * @param value of money on the account.
     */
    public void setValue(long value) {
        this.value = value;
    }
}
