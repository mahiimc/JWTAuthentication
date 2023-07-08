package com.imc.management.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * The Class AppUser.
 */
@JsonIgnoreProperties(value = "password")

@Data
@Table(name = "app_user")
@Entity

/**
 * Instantiates a new app user.
 */
@NoArgsConstructor
public class AppUser implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** The email. */
	private String email;

	/** The username. */
	private String username;

	/** The password. */
	private String password;

	/** The is enabled. */
	@Column(name = "is_enabled")
	private boolean isEnabled;
	
	/** The roles. */
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(
			name = "user_role",
			joinColumns = @JoinColumn(name = "id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
			)
	private List<Role> roles;

	/**
	 * Instantiates a new app user.
	 *
	 * @param email the email
	 * @param username the username
	 * @param password the password
	 */
	public AppUser(String email , String username , String password) {
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
}
