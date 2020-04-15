package com.formation.projet7.security;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.formation.projet7.model.Utilisateur;
import com.formation.projet7.repository.UserRepo;

@Service
@Transactional
public class SecurityService implements UserDetailsService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Utilisateur user = userRepo.findByUsername(username);
		return new UserDetails() {

			@Override
			public boolean isEnabled() {
				// TODO Auto-generated method stub
				return user.isEnabled();
			}

			@Override
			public boolean isCredentialsNonExpired() {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public boolean isAccountNonLocked() {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public boolean isAccountNonExpired() {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public String getUsername() {
				// TODO Auto-generated method stub
				return user.getUsername();
			}

			@Override
			public String getPassword() {
				// TODO Auto-generated method stub
				return user.getPassword();
			}

			
			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				// TODO Auto-generated method stub

				return List.of(new GrantedAuthority() {

					@Override
					public String getAuthority() {
						// TODO Auto-generated method stub
						if (user.isEnabled()) {
							
							return "USER";
						}
						
						return null;
					}
				}

				);

			}
			
			 
			
			
		};
	}

}
