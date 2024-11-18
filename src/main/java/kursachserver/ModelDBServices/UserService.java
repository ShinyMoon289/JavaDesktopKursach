package kursachserver.ModelDBServices;

import kursachserver.models.User;

import java.util.ArrayList;

public interface UserService {
	boolean addUser(User user);
	boolean deleteUser(int id);
	boolean updateUser(User user);
	User getUser(int id);
	ArrayList<User> getAllUsers();




}
