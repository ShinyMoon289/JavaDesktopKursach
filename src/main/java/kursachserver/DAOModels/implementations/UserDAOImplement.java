package kursachserver.DAOModels.implementations;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import kursachserver.DAOModels.UserDAO;
import kursachserver.HibSessionFactory;
import kursachserver.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class UserDAOImplement implements UserDAO {
	@Override
	public boolean addUser(User user) {
		boolean addedConfirmed = false;
		try{
			Session session = HibSessionFactory.getSessionFactory()
					.openSession();
			Transaction dbtransaction=session.beginTransaction();
			session.persist(user);
			dbtransaction.commit();
			session.close();
			addedConfirmed=true;
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return addedConfirmed;
	}

	@Override
	public boolean deleteUser(int id) {
		boolean deleteConfirmed=false;
		try{
			Session session = HibSessionFactory.getSessionFactory()
					.openSession();
			User user = session.getReference(User.class,id);

			Transaction dbtransaction=session.beginTransaction();
			session.remove(user);
			dbtransaction.commit();

			session.close();
			deleteConfirmed=true;
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return deleteConfirmed;
	}

	@Override
	public boolean updateUser(User user) {
		boolean updateConfirmed=false;
		try{
			Session session = HibSessionFactory.getSessionFactory()
					.openSession();
			Transaction dbtransaction=session.beginTransaction();
			session.merge(user);
			dbtransaction.commit();
			session.close();
			updateConfirmed=true;
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return updateConfirmed;
	}

	@Override
	public User getUser(int id) {
		User user = null;
		try{
			Session session = HibSessionFactory.getSessionFactory()
					.openSession();
			Transaction dbtransaction=session.beginTransaction();
			CriteriaBuilder critBuild = session.getCriteriaBuilder();
			CriteriaQuery<User> query = critBuild.createQuery(User.class);
			Root<User> root = query.from(User.class);
			query.select(root).where(critBuild.equal(root.get("id"),id));
			user = session.createQuery(query).getSingleResult();
			dbtransaction.commit();
			session.close();
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return user;
	}

	@Override
	public ArrayList<User> getAllUsers() {
		ArrayList<User> resultList=null;
		try{
			Session sesh=HibSessionFactory.getSessionFactory().openSession();
			CriteriaBuilder critBuild = sesh.getCriteriaBuilder();
			CriteriaQuery<User> query = critBuild.createQuery(User.class);
			Root<User> root = query.from(User.class);
			CriteriaQuery<User> getQuery = query.select(root);
			TypedQuery<User> result = sesh.createQuery(getQuery);
			resultList=(ArrayList<User>) result.getResultList();
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return resultList;
	}
}
