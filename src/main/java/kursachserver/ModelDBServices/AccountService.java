package kursachserver.ModelDBServices;

import kursachserver.models.Account;

import java.util.ArrayList;

public interface AccountService {
	boolean addAccount(Account acc);
	boolean deleteAccount(int id);
	boolean updateAccount(Account acc);
	Account getAcc(int id);
	ArrayList<Account> getAllAccount();
}
