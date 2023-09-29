package fr.doranco.interfaces;

import java.util.List;

import fr.doranco.ecommerce.entity.Adresse;

public interface IAdresseDao {

	int addAdresse(Adresse adresse, int userId) throws Exception;
	List<Adresse> getAdresses(int userId) throws Exception;
	int deleteAdresse(Adresse adresse, int userId) throws Exception;
}