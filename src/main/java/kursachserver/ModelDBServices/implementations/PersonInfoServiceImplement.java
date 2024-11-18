package kursachserver.ModelDBServices.implementations;

import kursachserver.DAOModels.PersonInfoDAO;
import kursachserver.DAOModels.implementations.PersonInfoDAOImplement;
import kursachserver.ModelDBServices.PersonInfoService;
import kursachserver.models.PersonInfo;
import org.hibernate.HibernateError;

import java.util.ArrayList;

public class PersonInfoServiceImplement implements PersonInfoService {
	PersonInfoDAO infoDAO = new PersonInfoDAOImplement();
	public PersonInfoServiceImplement(){}

	@Override
	public boolean addPersonInfo(PersonInfo info) {
		boolean isAdded=false;
		try{
			if(infoDAO.addInfo(info))
				isAdded=true;
		}
		catch (HibernateError hibex){
			hibex.printStackTrace();
		}
		return isAdded;
	}

	@Override
	public boolean deletePersonInfo(String mail) {
		boolean isDeleted=false;
		try{
			if(infoDAO.deleteInfo(mail))
				isDeleted=true;
		}
		catch (HibernateError hibex){
			hibex.printStackTrace();
		}
		return isDeleted;
	}

	@Override
	public boolean updatePersonInfo(PersonInfo info) {
		boolean isUpdated=false;
		try{
			if(infoDAO.updateInfo(info))
				isUpdated=true;
		}
		catch (HibernateError hibex){
			hibex.printStackTrace();
		}
		return isUpdated;
	}

	@Override
	public PersonInfo getPersonInfo(String mail) {
		PersonInfo info = null;
		try{
			info = infoDAO.getInfo(mail);
		}catch (HibernateError hibex){
			hibex.printStackTrace();
		}
		return info;
	}

	@Override
	public ArrayList<PersonInfo> getAllInfos() {
		ArrayList<PersonInfo> resultList=null;
		try{
			resultList=infoDAO.getAllInfo();

		}catch (HibernateError hibex) {
			hibex.printStackTrace();
		}
		return resultList;
	}

}
