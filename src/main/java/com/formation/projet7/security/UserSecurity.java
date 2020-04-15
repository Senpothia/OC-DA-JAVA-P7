package com.formation.projet7.security;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.formation.projet7.model.UserRole;
import com.formation.projet7.model.Utilisateur;
import com.formation.projet7.repository.UserRepo;

public class UserSecurity  implements UserDetailsService{
	
	@Autowired
	private UserRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Utilisateur user = userRepo.findByUsername(username);
		List<GrantedAuthority> authorities = buildAuthorities(user.getUserRole());
		return builderUser(user, authorities);
	}
	
	private User builderUser(Utilisateur user, List<GrantedAuthority> authorities) {
		
		
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}
	
	private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRoles){
		
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		
		for (UserRole userRole: userRoles) {
			auths.add(new SimpleGrantedAuthority(userRole.getRole()));
			
		}
		return new ArrayList<GrantedAuthority>(auths);
	}

}
