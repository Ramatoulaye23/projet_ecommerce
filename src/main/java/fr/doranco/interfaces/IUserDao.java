package fr.doranco.interfaces;


import java.util.List;

import fr.doranco.entity.User;

public interface IUserDao {

	void addUser(User user) throws Exception;
	User getUserById(Integer id) throws Exception;
	User getUserByEmail(String email) throws Exception;
	void deleteUser(int id) throws Exception;
	List<User> getUsers() throws Exception;
	void updatePassword(String password, Integer userId);

}
