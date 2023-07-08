package com.imc.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imc.management.model.Role;

// TODO: Auto-generated Javadoc
/**
 * The Interface RoleRepository.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the role
	 */
	Role findByName(String name);

}
