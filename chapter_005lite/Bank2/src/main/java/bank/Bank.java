package bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Bank class that stores unique properties and methods for all bankoperations and clients.
 *
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @version 1
 * @since 26.03.2017
 */
public class Bank {
    /**
     * Store users and their bank accounts.
     */
    private Map<User, List<Account>> users;
    /**
     * Bank class constructor.
     *
     * @param users  initial massive of users and accounts
     */
    public Bank(Map<User, List<Account>> users) {
        this.users = users;
    }

    /**
     * Is user in bank database.
     * @param user to search
     *
     * @return true if user exists in database and false otherwise.
     */
    public boolean isUserExists(User user) {
        return users.containsKey(user);
    }
    /**
     * Add new user in thebank.
     *
     * @param user new user
     *
     * @throws UserAlreadyExistsExeption if user already in bank database
     */
    public void addUser(User user) throws UserAlreadyExistsExeption {
        // - добавление пользователя.
        if (users.containsKey(user)) {
            throw new UserAlreadyExistsExeption("User that you want to add already exists");
        } else {
            users.put(user, new ArrayList<Account>());
        }

    }
    /**
     * Delete new user from the bank database.
     *
     * @param user to delete
     *
     * @throws UserNotExistsExeption if user not exists in  the bank database
     */
    public void deleteUser(User user) throws UserNotExistsExeption {
        //- удаление пользователя.
        if (!users.containsKey(user)) {
            throw new UserNotExistsExeption("User that you want to delete is not exists");
        } else {
            users.remove(user);
        }
    }
    /**
     * Add new account to the existing user.
     *
     * @param user to which we want to add new account
     * @param account to add
     *
     * @throws UserNotExistsExeption if user not exists in  the bank database
     * @throws AccountAlreadyExistsExeption if this account already exists for this user
     */
    public void addAccountToUser(User user, Account account) throws UserNotExistsExeption, AccountAlreadyExistsExeption {
        // - добавить счёт пользователю.
        if (!users.containsKey(user)) {
            throw new UserNotExistsExeption("User to whom you want to add account is not exists");
        } else if (users.get(user).contains(account)) {
            throw new AccountAlreadyExistsExeption("Account that you want to add to this user is already exists");
        } else {
            users.get(user).add(account);
        }
    }
    /**
     * Delete account for the existing user.
     *
     * @param user to which we want to delete account
     * @param account to delete
     *
     * @throws UserNotExistsExeption if user not exists in  the bank database
     * @throws AccountNotExistsExeption if this account not exists for this user
     */
    public void deleteAccountFromUser(User user, Account account) throws UserNotExistsExeption, AccountNotExistsExeption {
        // - удалить один счёт пользователя.
        if (!users.containsKey(user)) {
            throw new UserNotExistsExeption("User from whom you want to delete this account is not exists");
        } else if (!users.get(user).contains(account)) {
            throw new AccountNotExistsExeption("Account that you want to delete to this user is not exists");
        } else {
            users.get(user).remove(account);
        }
    }
    /**
     * Get all accounts for the existing user.
     *
     * @param user to which we want to delete account
     * @return all user accounts
     * @throws UserNotExistsExeption if user not exists in  the bank database
     */
    public List<Account> getUserAccounts(User user) throws UserNotExistsExeption {
        //- получить список счетов для пользователя.
        List<Account> result = null;
        if (!users.containsKey(user)) {
            throw new UserNotExistsExeption("User from whom you want to get all accounts is not exists");
        } else {
            result = users.get(user);
        }
        return result;
    }
    /**
     * Transfer money from one account to another.
     *
     * @param srcUser user from which we want to get money account
     * @param srcRequisites account from which we want to get money
     * @param dstUser user to whom we want to give money
     * @param dstRequisites account to which we want to give money
     * @param amount of money to transfer
     * @return is operation was finished successfully
     */
    public boolean transferMoney(User srcUser, long srcRequisites, User dstUser, long dstRequisites, long amount) {
        // - метод для перечисления денег с одного счёта на другой счёт:
        // если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят) должен вернуть false.
        boolean result = false;

        try {
            if (!users.containsKey(srcUser) || !users.containsKey(dstUser)) {
                throw new UserNotExistsExeption("User is not exists");
            } else {
                Account srcAccount = this.getAccountFromUser(srcUser, srcRequisites);
                Account dstAccount = this.getAccountFromUser(dstUser, dstRequisites);
                if (srcAccount == null || dstAccount == null) {
                    throw new AccountNotExistsExeption("Account is not exists");
                } else if (srcAccount.getValue() < amount) {
                    throw new NoSuchMoneyOnAccountExeption("Account from which you want to transfer money doesn't have such amount of money");
                } else {
                    srcAccount.setValue(srcAccount.getValue() - amount);
                    dstAccount.setValue(dstAccount.getValue() + amount);
                    result = true;
                }
            }
        } catch (UserNotExistsExeption unee) {
            unee.printStackTrace();
        } catch (AccountNotExistsExeption anee) {
            anee.printStackTrace();
        } catch (NoSuchMoneyOnAccountExeption nsmoae) {
            nsmoae.printStackTrace();
        }
        return result;
    }

    /**
     * Get account from the user with this requisites.
     *
     * @param user to search account
     * @param requisites of the account
     * @return the account
     */
    public Account getAccountFromUser(User user, long requisites) {
        Account result = null;
        List<Account> list = users.get(user);
        for (Account account : list) {
            if (account.getRequisites() == requisites) {
                result = account;
            }
        }
        return result;
    }

}
