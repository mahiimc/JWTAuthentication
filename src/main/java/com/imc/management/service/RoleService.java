package com.imc.management.service;

import java.util.List;

import com.imc.management.model.Role;

/**
 * The Interface RoleService.
 */
public interface RoleService {
	
	/**
	 * Adds the role.
	 *
	 * @param role the role
	 */
	public void addRole(Role role);
	
	/**
	 * Adds the roles.
	 *
	 * @param roles the roles
	 */
	public void addRoles(List<Role> roles);
	
	/**
	 * Find role by name.
	 *
	 * @param name the name
	 * @return the role
	 */
	public Role findRoleByName(String name);

}
