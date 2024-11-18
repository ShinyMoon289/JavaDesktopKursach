package kursachserver.models;

import jakarta.persistence.*;

import java.sql.Date;
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int userID;

	@OneToOne
	@JoinColumn(name = "email")
	private PersonInfo personInfo;
	@Column(name="role")
	private String role;

	@Column(name="passwordhash")
	private String passwordHash;

	public int getUserID(){
		return this.userID;
	}

	public void setUserID(int newid) {
		this.userID = newid;
	}


}



