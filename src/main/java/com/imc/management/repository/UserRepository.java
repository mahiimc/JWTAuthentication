package com.imc.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imc.management.model.AppUser;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserRepository.
 */
@Repository
public interface UserRepository extends JpaRepository<AppUser, Long>{
	
		/**
		 * Find user by username.
		 *
		 * @param username the username
		 * @return the app user
		 */
		AppUser findUserByUsername(String username);
		
		/**
		 * Find user by email.
		 *
		 * @param email the email
		 * @return the app user
		 */
		AppUser findUserByEmail(String email);
		
}
