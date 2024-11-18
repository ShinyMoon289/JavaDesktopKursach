package kursachserver.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "account")
public class Account {

	@OneToOne
	@JoinColumn(name = "userid")
	private User user;

	@Column(name = "registered")
	private Date registered;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

}
