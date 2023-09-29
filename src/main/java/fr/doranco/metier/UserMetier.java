package fr.doranco.metier;

import java.util.List;

import fr.doranco.ecommerce.entity.User;
import fr.doranco.ecommerce.metier.IUserMetier;
import fr.doranco.ecommerce.model.IUserDao;
import fr.doranco.ecommerce.model.UserDao;

public class UserMetier implements IUserMetier {

	private final IUserDao userDao = new UserDao();
	
	@Override
	public void addUser(User user) throws Exception {
		userDao.addUser(user);
	}

	@Override
	public User seConnecter(String email, String password) throws Exception {
		// TODO Auto-generated method stub
		
		if (email == null || email.trim().isEmpty()
				|| password == null || password.trim().isEmpty()) {
				
				return null;
			}

		
		User userCourant = userDao.getUserByEmail(email);
		
	
		if(userCourant==null)
		{
			return null;
		}
		else
		{
			if( userCourant.getMotDePasse().equals(password)) { 

				return userCourant; }
			else 
			{
				return null;
			}
		}
		
		
	}

	@Override
	public void deleteUser(int id) throws Exception {
		userDao.deleteUser(id);
		
	}

	@Override
	public List<User> getUsers() throws Exception {
		
		return userDao.getUsers();
	}

	@Override
	public User getUserByEmail(String email) throws Exception {
		return userDao.getUserByEmail(email);
	}
	
	@Override
	public User getUserById(Integer id) throws Exception {
		return userDao.getUserById(id);
	}

	@Override
	public void updatePassword(String password, Integer userId) throws Exception {
		userDao.updatePassword(password, userId);
		
	}

}
