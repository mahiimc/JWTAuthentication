package com.imc.management.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.imc.management.enums.ApplicationRoles;
import com.imc.management.model.Role;
import com.imc.management.service.RoleService;

/**
 * The AppDefaultsInitilizer class is a Spring component that implements the CommandLineRunner interface.
 * It is responsible for initializing the application defaults during application startup.
 */

@Component
public class AppDefaultsInitilizer implements CommandLineRunner {

	@Autowired
	private RoleService roleService;
	
	/**
	 * This method is invoked during the application startup.
	 * It adds the application roles to the system by iterating over the ApplicationRoles enum.
	 * Each role is converted into a Role object and added using the RoleService.
	 *
	 * @param args the command-line arguments
	 * @throws Exception if an error occurs during the initialization process
	 */

	@Override
	public void run(String... args) throws Exception {

		for (ApplicationRoles role : com.imc.management.enums.ApplicationRoles.values()) {
			Role newRole = new Role(role.toString());
			roleService.addRole(newRole);
		}
		
	}

}
