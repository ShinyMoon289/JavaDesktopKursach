package kursachserver.DAOModels.implementations;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import kursachserver.DAOModels.AccountDAO;
import kursachserver.HibSessionFactory;
import kursachserver.models.Account;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.ArrayList;

public class AccountDAOImplementation implements AccountDAO {
	public boolean addAccount(Account acc){
		boolean AddedConfirmed = false;
		try{
			Session session = HibSessionFactory.getSessionFactory()
					.openSession();
			Transaction dbtransaction=session.beginTransaction();
			session.persist(acc);
			dbtransaction.commit();
			session.close();
			AddedConfirmed=true;
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return AddedConfirmed;
	}
	public boolean deleteAccount(int id){
		boolean deleteConfirmed=false;
		try{
			Session session = HibSessionFactory.getSessionFactory()
					.openSession();
			Account acc = session.getReference(Account.class,id);

			Transaction dbtransaction=session.beginTransaction();
			session.remove(acc);
			dbtransaction.commit();

			session.close();
			deleteConfirmed=true;
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return deleteConfirmed;
	}

	public boolean updateAccount(Account acc){
		boolean updateConfirmed=false;
		try{
			Session session = HibSessionFactory.getSessionFactory()
					.openSession();
			Transaction dbtransaction=session.beginTransaction();
			session.merge(acc);
			dbtransaction.commit();
			session.close();
			updateConfirmed=true;
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return updateConfirmed;
	}
	public Account getAcc(int id){
		Account acc = null;
		try{
			Session session = HibSessionFactory.getSessionFactory()
					.openSession();
			Transaction dbtransaction=session.beginTransaction();
			CriteriaBuilder critBuild = session.getCriteriaBuilder();
			CriteriaQuery<Account> query = critBuild.createQuery(Account.class);
			Root<Account> root = query.from(Account.class);
			query.select(root).where(critBuild.equal(root.get("id"),id));
			acc = session.createQuery(query).getSingleResult();
			dbtransaction.commit();
			session.close();
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return acc;

	}
	public ArrayList<Account> getAllAccounts(){
		ArrayList<Account> resultList=null;
		try{

			Session sesh=HibSessionFactory.getSessionFactory().openSession();
			CriteriaBuilder critBuild = sesh.getCriteriaBuilder();
			CriteriaQuery<Account> query = critBuild.createQuery(Account.class);
			Root<Account> root = query.from(Account.class);
			CriteriaQuery<Account> getQuery = query.select(root);
			TypedQuery<Account> result = sesh.createQuery(getQuery);
			resultList=(ArrayList<Account>) result.getResultList();
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return resultList;
	}
}
