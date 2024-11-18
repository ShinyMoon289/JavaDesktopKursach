package kursachserver.ModelDBServices;

import kursachserver.models.PersonInfo;
import kursachserver.models.User;

import java.util.ArrayList;

public interface PersonInfoService {
	boolean addPersonInfo(PersonInfo info);
	boolean deletePersonInfo(String mail);
	boolean updatePersonInfo(PersonInfo info);
	PersonInfo getPersonInfo(String mail);
	ArrayList<PersonInfo> getAllInfos();

}
