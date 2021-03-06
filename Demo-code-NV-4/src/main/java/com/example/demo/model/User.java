package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name ="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_u;
	private String username;
	private String passwork;
	private int id_personnel;
	private int id_account;
	
	public int getId_u() {
		return id_u;
	}
	public void setId_u(int id_u) {
		this.id_u = id_u;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswork() {
		return passwork;
	}
	public void setPasswork(String passwork) {
		this.passwork = passwork;
	}
	public int getId_personnel() {
		return id_personnel;
	}
	public void setId_personnel(int id_personnel) {
		this.id_personnel = id_personnel;
	}
	public int getId_account() {
		return id_account;
	}
	public void setId_account(int id_account) {
		this.id_account = id_account;
	}
	
	public User() {
		
	}
	public User(int id, String username, String passwork, int id_personnel, int id_account) {
		super();
		this.id_u = id;
		this.username = username;
		this.passwork = passwork;
		this.id_personnel = id_personnel;
		this.id_account = id_account;
		
	}
	
	
	
	
	
	
}
