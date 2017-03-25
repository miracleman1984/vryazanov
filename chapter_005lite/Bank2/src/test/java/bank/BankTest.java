package bank;

import org.junit.Test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by vr on 25.03.2017.
 */
public class BankTest {
    @Test
    public void whenAddNewUserThenHeMustExists() throws UserAlreadyExistsExeption {
        User user1 = new User(12345, "Qwerty");
        Map<User, List<Account>> map = new HashMap<User, List<Account>>();
        Bank bank = new Bank(map);
        bank.addUser(user1);
        boolean result = bank.isUserExists(user1);
        assertTrue(result);
    }

    @Test(expected = UserAlreadyExistsExeption.class)
    public void whenAddExistingUserThenMustBeError() throws UserAlreadyExistsExeption {
        User user1 = new User(12345, "Qwerty");
        Map<User, List<Account>> map = new HashMap<User, List<Account>>();
        Bank bank = new Bank(map);
        bank.addUser(user1);
        bank.addUser(user1);
    }

    @Test
    public void whenDeleteExistingUserThenHeMustNotBeFound() throws UserAlreadyExistsExeption, UserNotExistsExeption {
        User user1 = new User(12345, "Qwerty");
        Map<User, List<Account>> map = new HashMap<User, List<Account>>();
        Bank bank = new Bank(map);
        bank.addUser(user1);
        bank.deleteUser(user1);
        boolean result = bank.isUserExists(user1);
        assertFalse(result);
    }

    @Test(expected = UserNotExistsExeption.class)
    public void whenDeleteNonExistingUserThenMustBeError() throws UserAlreadyExistsExeption, UserNotExistsExeption {
        User user1 = new User(12345, "Qwerty");
        User user2 = new User(12346, "Qwerty");
        Map<User, List<Account>> map = new HashMap<User, List<Account>>();
        Bank bank = new Bank(map);
        bank.addUser(user1);
        bank.deleteUser(user2);
    }

    @Test
    public void whenAddAccountToExistingUserThenItMustNotBeFound() throws UserAlreadyExistsExeption, UserNotExistsExeption, AccountAlreadyExistsExeption {
        User user1 = new User(12345, "Qwerty");
        Account account1 = new Account(987654321, 1000000);
        Map<User, List<Account>> map = new HashMap<User, List<Account>>();
        Bank bank = new Bank(map);
        bank.addUser(user1);
        bank.addAccountToUser(user1, account1);
        boolean result = (bank.getUserAccounts(user1) == null);
        assertFalse(result);
    }

    @Test(expected = UserNotExistsExeption.class)
    public void whenAddAccountToNonExistingUserThenThenMustBeError() throws UserAlreadyExistsExeption, UserNotExistsExeption, AccountAlreadyExistsExeption {
        User user1 = new User(12345, "Qwerty");
        User user2 = new User(12346, "Qwerty");
        Account account1 = new Account(987654321, 1000000);
        Map<User, List<Account>> map = new HashMap<User, List<Account>>();
        Bank bank = new Bank(map);
        bank.addUser(user1);
        bank.addAccountToUser(user2, account1);
    }

    @Test(expected = AccountAlreadyExistsExeption.class)
    public void whenAddAccountToExistingUserButSuchAccountAlreadyExistsThenThenMustBeError() throws UserAlreadyExistsExeption, UserNotExistsExeption, AccountAlreadyExistsExeption {
        User user1 = new User(12345, "Qwerty");
        Account account1 = new Account(987654321, 1000000);
        Map<User, List<Account>> map = new HashMap<User, List<Account>>();
        Bank bank = new Bank(map);
        bank.addUser(user1);
        bank.addAccountToUser(user1, account1);
        bank.addAccountToUser(user1, account1);
    }

    @Test
    public void whenGetAllAccountOfTheUserThenShouldBeRightAcccounts() throws UserAlreadyExistsExeption, UserNotExistsExeption, AccountAlreadyExistsExeption {
        User user1 = new User(12345, "Qwerty");
        Account account1 = new Account(987654321, 1000000);
        Map<User, List<Account>> map = new HashMap<User, List<Account>>();
        Bank bank = new Bank(map);
        bank.addUser(user1);
        bank.addAccountToUser(user1, account1);
        List<Account> result = bank.getUserAccounts(user1);
        List<Account> expected = new ArrayList<Account>();
        expected.add(account1);
        assertThat(result, is(expected));
    }



    @Test(expected = UserNotExistsExeption.class)
    public void whenGetAllAccountOfTheNonExistingUserThenMustBeError() throws UserAlreadyExistsExeption, UserNotExistsExeption, AccountAlreadyExistsExeption {
        User user1 = new User(12345, "Qwerty");
        User user2 = new User(12346, "Qwerty");
        Account account1 = new Account(987654321, 1000000);
        Map<User, List<Account>> map = new HashMap<User, List<Account>>();
        Bank bank = new Bank(map);
        bank.addUser(user1);
        bank.addAccountToUser(user2, account1);
    }

    @Test
    public void whenTransferMoneyFromOneAccountToAnotherThenShouldBeRight() throws UserAlreadyExistsExeption, UserNotExistsExeption, AccountAlreadyExistsExeption {
        User user1 = new User(12345, "Qwerty");
        User user2 = new User(12346, "Qwerty");
        Account account1 = new Account(987654321, 1000000);
        Account account2 = new Account(123456789, 1000000);
        Map<User, List<Account>> map = new HashMap<User, List<Account>>();
        Bank bank = new Bank(map);
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser(user1, account1);
        bank.addAccountToUser(user2, account2);
        bank.transferMoney(user1, 987654321, user2, 123456789, 500000);
        Account accountUser1 = bank.getAccountFromUser(user1, 987654321);
        Account accountUser2 = bank.getAccountFromUser(user2, 123456789);
        assertThat(accountUser1.getValue(), is(500000L));
        assertThat(accountUser2.getValue(), is(1500000L));
    }

    @Test
    public void whenTransferMoneyFromOneAccountToAnotherAndUserTheSameThenShouldBeRight() throws UserAlreadyExistsExeption, UserNotExistsExeption, AccountAlreadyExistsExeption {
        User user1 = new User(12345, "Qwerty");
        Account account1 = new Account(987654321, 1000000);
        Account account2 = new Account(123456789, 1000000);
        Map<User, List<Account>> map = new HashMap<User, List<Account>>();
        Bank bank = new Bank(map);
        bank.addUser(user1);
        bank.addAccountToUser(user1, account1);
        bank.addAccountToUser(user1, account2);
        bank.transferMoney(user1, 987654321, user1, 123456789, 500000);
        Account accountUser1 = bank.getAccountFromUser(user1, 987654321);
        Account accountUser2 = bank.getAccountFromUser(user1, 123456789);
        assertThat(accountUser1.getValue(), is(500000L));
        assertThat(accountUser2.getValue(), is(1500000L));
    }

    @Test
    public void whenTransferMoneyFromOneAccountToAnotherAndNoSushUserThenShouldBeFalse() throws UserAlreadyExistsExeption, UserNotExistsExeption, AccountAlreadyExistsExeption {
        User user1 = new User(12345, "Qwerty");
        User user2 = new User(12346, "Qwerty");
        Account account1 = new Account(987654321, 1000000);
        Map<User, List<Account>> map = new HashMap<User, List<Account>>();
        Bank bank = new Bank(map);
        bank.addUser(user1);
        bank.addAccountToUser(user1, account1);
        boolean result = bank.transferMoney(user1, 987654321, user2, 123456789, 500000);
        assertFalse(result);
    }

    @Test
    public void whenTransferMoneyFromOneAccountToAnotherAndNoSushAccountThenShouldBeFalse() throws UserAlreadyExistsExeption, UserNotExistsExeption, AccountAlreadyExistsExeption {
        User user1 = new User(12345, "Qwerty");
        User user2 = new User(12346, "Qwerty");
        Account account2 = new Account(123456789, 1000000);
        Account account1 = new Account(987654321, 1000000);
        Map<User, List<Account>> map = new HashMap<User, List<Account>>();
        Bank bank = new Bank(map);
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser(user1, account1);
        bank.addAccountToUser(user2, account2);
        boolean result = bank.transferMoney(user1, 1, user2, 123456789, 500000);
        assertFalse(result);
    }

    @Test
    public void whenTransferMoneyFromOneAccountToAnotherAndNoSushMoneyThenShouldBeFalse() throws UserAlreadyExistsExeption, UserNotExistsExeption, AccountAlreadyExistsExeption {
        User user1 = new User(12345, "Qwerty");
        User user2 = new User(12346, "Qwerty");
        Account account1 = new Account(987654321, 1);
        Account account2 = new Account(123456789, 1000000);
        Map<User, List<Account>> map = new HashMap<User, List<Account>>();
        Bank bank = new Bank(map);
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser(user1, account1);
        bank.addAccountToUser(user2, account2);
        boolean result = bank.transferMoney(user1, 987654321, user2, 123456789, 500000);
        assertFalse(result);
    }


}