package fr.doranco.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "params")
public class Params {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "cleCryptage", length = 25, nullable = false)
	private byte[] cleCryptage;
	@Column(name = "algorithme", length = 25, nullable = false)
	private byte[] algorithme;

	public Params() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getCleCryptage() {
		return cleCryptage;
	}

	public void setCle_cryptage(byte[] cleCryptage) {
		this.cleCryptage = cleCryptage;
	}

	@Override
	public String toString() {
		return "Params [id=" + id + ", cleCryptage=" + Arrays.toString(cleCryptage) + "]";
	}
	
	
}
