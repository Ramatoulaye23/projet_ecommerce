package fr.doranco.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.doranco.ecommerce.entity.Adresse;
import fr.doranco.interfaces.IAdresseDao;

public class AdresseDao implements IAdresseDao {

	@Override
	public int addAdresse(Adresse adresse, int userId) throws Exception {
		Connection connection = EcommerceDataSource.getInstance().getConnection();
		String requete = "INSERT INTO adresse(numero, rue, ville, code_postal, user_id)"
				+ " VALUES(?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, adresse.getNumero());
		ps.setString(2, adresse.getRue());
		ps.setString(3, adresse.getVille());
		ps.setString(4, adresse.getCodePostal());
		ps.setInt(5, userId);
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		if (rs != null && rs.next()) {
			return rs.getInt(1);
		}
		return 0;
	}

	@Override
	public List<Adresse> getAdresses(int userId) throws Exception {
		Connection connection = EcommerceDataSource.getInstance().getConnection();
		String requete = "SELECT * FROM adresse WHERE user_id = ?";
		PreparedStatement ps = connection.prepareStatement(requete);
		ps.setInt(1, userId);
		ResultSet rs = ps.executeQuery();
		List<Adresse> adresses = new ArrayList<Adresse>();
		if (rs != null) {
			while (rs.next()) {
				Adresse adresse = new Adresse();
				adresse.setId(rs.getInt("id"));
				adresse.setNumero(rs.getString("numero"));
				adresse.setRue(rs.getString("rue"));
				adresse.setVille(rs.getString("ville"));
				adresse.setCodePostal(rs.getString("code_postal"));
				adresses.add(adresse);
			}
		}
		return adresses;
	}

	@Override
	public int deleteAdresse(Adresse adresse, int userId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
