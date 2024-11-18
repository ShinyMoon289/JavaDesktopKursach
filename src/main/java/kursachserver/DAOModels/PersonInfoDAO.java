package kursachserver.DAOModels;
import kursachserver.models.PersonInfo;
import java.util.ArrayList;
public interface PersonInfoDAO {
	boolean addInfo(PersonInfo info);
	boolean deleteInfo(String mail);
	boolean updateInfo(PersonInfo info);
	PersonInfo getInfo(String email);
	ArrayList<PersonInfo> getAllInfo();
}
