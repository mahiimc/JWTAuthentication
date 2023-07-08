package com.imc.management.model;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import lombok.Data;



@Data
public class SecuredUser implements UserDetails {
	
	/** The Constant serialVersionUID. */
	
	private static final long serialVersionUID = 1L;
	
	/** The user. */
	private AppUser user;
	
	/**
	 * Instantiates a new secured user.
	 */
	public SecuredUser() {
		
	}
	
	/**
	 * Instantiates a new secured user.
	 *
	 * @param user the user
	 */
	public SecuredUser(AppUser user) { 
		this.user = user;
	}

	/**
	 * Gets the authorities.
	 *
	 * @return the authorities
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName()))
				.toList();
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	@Override
	public String getUsername() {
		return this.user.getUsername();
	}

	/**
	 * Checks if is account non expired.
	 *
	 * @return true, if is account non expired
	 */
	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	/**
	 * Checks if is account non locked.
	 *
	 * @return true, if is account non locked
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * Checks if is credentials non expired.
	 *
	 * @return true, if is credentials non expired
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * Checks if is enabled.
	 *
	 * @return true, if is enabled
	 */
	@Override
	public boolean isEnabled() {
		return this.getUser().isEnabled();
	}

}
