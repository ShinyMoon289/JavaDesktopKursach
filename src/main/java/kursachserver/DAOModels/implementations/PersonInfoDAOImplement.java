package kursachserver.DAOModels.implementations;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import kursachserver.DAOModels.PersonInfoDAO;
import kursachserver.HibSessionFactory;
import kursachserver.models.PersonInfo;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class PersonInfoDAOImplement implements PersonInfoDAO {
	public boolean addInfo(PersonInfo info){
		boolean addedConfirmed = false;
		try{
			Session session = HibSessionFactory.getSessionFactory()
					.openSession();
			Transaction dbtransaction=session.beginTransaction();
			session.persist(info);
			dbtransaction.commit();
			session.close();
			addedConfirmed=true;
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return addedConfirmed;
	}
	public boolean deleteInfo(String mail){
		boolean deleteConfirmed=false;
		try{
			Session session = HibSessionFactory.getSessionFactory()
					.openSession();
			PersonInfo info = session.getReference(PersonInfo.class,mail);

			Transaction dbtransaction=session.beginTransaction();
			session.remove(info);
			dbtransaction.commit();

			session.close();
			deleteConfirmed=true;
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return deleteConfirmed;
	}

	public boolean updateInfo(PersonInfo info){
		boolean updateConfirmed=false;
		try{
			Session session = HibSessionFactory.getSessionFactory()
					.openSession();
			Transaction dbtransaction=session.beginTransaction();
			session.merge(info);
			dbtransaction.commit();
			session.close();
			updateConfirmed=true;
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return updateConfirmed;
	}
	public PersonInfo getInfo(String email){
		PersonInfo info = null;
		try{
			Session session = HibSessionFactory.getSessionFactory()
					.openSession();
			Transaction dbtransaction=session.beginTransaction();
			CriteriaBuilder critBuild = session.getCriteriaBuilder();
			CriteriaQuery<PersonInfo> query = critBuild.createQuery(PersonInfo.class);
			Root<PersonInfo> root = query.from(PersonInfo.class);
			query.select(root).where(critBuild.equal(root.get("email"),email));
			info = session.createQuery(query).getSingleResult();
			dbtransaction.commit();
			session.close();
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return info;

	}
	public ArrayList<PersonInfo> getAllInfo(){
		ArrayList<PersonInfo> resultList=null;
		try{
			Session sesh=HibSessionFactory.getSessionFactory().openSession();
			CriteriaBuilder critBuild = sesh.getCriteriaBuilder();
			CriteriaQuery<PersonInfo> query = critBuild.createQuery(PersonInfo.class);
			Root<PersonInfo> root = query.from(PersonInfo.class);
			CriteriaQuery<PersonInfo> getQuery = query.select(root);
			TypedQuery<PersonInfo> result = sesh.createQuery(getQuery);
			resultList=(ArrayList<PersonInfo>) result.getResultList();
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return resultList;
	}

}
