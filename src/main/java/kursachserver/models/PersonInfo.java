package kursachserver.models;

import jakarta.persistence.*;

import java.sql.Date;
@Table(name="personinfo")
@Entity
public class PersonInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int personID;
	@Column(name = "firstname")
	private String firstName;
	@Column(name="lastname")
	private String lastName;
	@Column(name = "middlename")
	private String middleName;
	@Column(name = "telephone")
	private int telephone;
	@Column(name="birthday")
	private Date birthdate;
	@Column(name = "email")
	private String email;



}
