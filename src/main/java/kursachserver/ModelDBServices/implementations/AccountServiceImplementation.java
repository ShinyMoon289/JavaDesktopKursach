package kursachserver.ModelDBServices.implementations;

import kursachserver.DAOModels.AccountDAO;
import kursachserver.DAOModels.UserDAO;
import kursachserver.DAOModels.implementations.AccountDAOImplementation;
import kursachserver.ModelDBServices.AccountService;
import kursachserver.models.Account;
import org.hibernate.HibernateError;

import java.util.ArrayList;

public class AccountServiceImplementation implements AccountService {
	AccountDAO accDao=new AccountDAOImplementation();
	public AccountServiceImplementation(){}

	public boolean addAccount(Account acc){
		boolean isAdded=false;
		try{
			if(accDao.addAccount(acc))
				isAdded=true;
		}
		catch (HibernateError hibex){
			hibex.printStackTrace();
		}
		return isAdded;
	}

	public boolean deleteAccount(int id){
		boolean isDeleted=false;
		try{
			if(accDao.deleteAccount(id))
				isDeleted=true;
		}
		catch (HibernateError hibex){
			hibex.printStackTrace();
		}
		return isDeleted;
	}

	public boolean updateAccount(Account acc){
		boolean isUpdated=false;
		try{
			if(accDao.updateAccount(acc))
				isUpdated=true;
		}
		catch (HibernateError hibex){
			hibex.printStackTrace();
		}
		return isUpdated;
	}
	public Account getAcc(int id){
		Account acc=null;
		try{
			acc=accDao.getAcc(id);
		}
		catch (HibernateError hibex){
			hibex.printStackTrace();
		}
		return acc;
	}
	public ArrayList<Account> getAllAccount(){
		ArrayList<Account> resultList=null;
		try{
			resultList=accDao.getAllAccounts();
		}
		catch (HibernateError hibex){
			hibex.printStackTrace();
		}
		return resultList;
	}

}
