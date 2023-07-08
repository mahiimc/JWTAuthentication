package com.imc.management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;



@Data
@Entity
@Table(name = "role")

/**
 * The class Role 
 */
public class Role {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Integer id;
	
	/** The name. */
	private String name;
	
	
	/**
	 * Instantiates a new role.
	 */
	public Role() {
		// NOP
	}
	
	/**
	 * Instantiates a new role.
	 *
	 * @param name the name
	 */
	public Role(String name) {
		this.name = name;
	}

}
