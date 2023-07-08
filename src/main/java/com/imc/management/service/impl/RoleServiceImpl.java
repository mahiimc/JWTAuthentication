package com.imc.management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imc.management.model.Role;
import com.imc.management.repository.RoleRepository;
import com.imc.management.service.RoleService;


/**
 * {@inheritDoc}
 */

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void addRole(Role role) {
		Role existingRole = roleRepository.findByName(role.getName());
		if (existingRole == null) {
			roleRepository.save(role);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addRoles(List<Role> roles) {

	}

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public Role findRoleByName(String name) {
		return this.roleRepository.findByName(name);
	}

}
