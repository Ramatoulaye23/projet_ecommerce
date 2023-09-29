package fr.doranco.metier;

import java.util.List;

import fr.doranco.ecommerce.entity.User;

public interface IUserMetier {

	void addUser(User user) throws Exception;
	User getUserByEmail(String email) throws Exception;
	User seConnecter(String email, String password) throws Exception;
	void deleteUser(int id) throws Exception;
	List<User> getUsers() throws Exception;
	void updatePassword(String password, Integer userId) throws Exception;
	User getUserById(Integer id) throws Exception;
}
