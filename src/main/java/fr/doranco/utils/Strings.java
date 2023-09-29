package fr.doranco.utils;

import fr.doranco.ecommerce.entity.User;

public final class Strings {

	private Strings() {
		// TODO Auto-generated constructor stub
	}

	public static String getEmployeAuFormatXmlString(User user)
	{
		String str = "<user>\n" +
	                 "<id>"+user.getId()+"</id>\n" +
	                 "<nom>"+user.getNom()+"</nom>\n" +
	                 "<prenom>"+user.getPrenom()+"</prenom>\n" +
	                 "<email>"+user.getEmail()+"</email>\n" +
	                 "<genre>"+user.getGenre()+"</genre>\n" +
	                 "<dateNaissance>"+user.getDateNaissance()+"</dateNaissance>\n" +
	                 "</employe>";
		
		return str;
	}
	
	
	public static String getEmployeAuFormatJsonString(User user)
	{
		String str = "{"+
	                 "\"id\":"+user.getId() + ","+
	                 "\"nom\":\""+user.getNom()+"\"," +
	                 "\"prenom\":\""+user.getPrenom()+"\"," +
	                 "\"email\":\""+user.getEmail()+"\"," +
	                 "\"genre\":\""+user.getGenre()+"\"," +
	                 "\"dateNaissance\":\""+user.getDateNaissance()+"\"" +
	                 "}";
		
		return str;
	}
	
}
