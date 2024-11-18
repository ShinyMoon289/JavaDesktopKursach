package kursachserver.DAOModels;

import kursachserver.models.Account;
import kursachserver.models.User;

import java.util.ArrayList;

public interface AccountDAO {
	boolean addAccount(Account acc);
	boolean deleteAccount(int id);
	boolean updateAccount(Account acc);
	Account getAcc(int id);
	ArrayList<Account> getAllAccounts();
}
