package com.formation.projet7.service.jpa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.formation.projet7.model.User;
import com.formation.projet7.repository.UserRepo;
import com.formation.projet7.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepo userRepo;
	
	@Override
	public List<User> listerUser() {
		
		List<User> users = userRepo.findAll();
		return users;
	}

	@Override
	public User obtenirUser(Integer id) {
		
		User user = userRepo.getOne(id);
		return user;
	}

	@Override
	public User obtenirUser(String string) {
		
		User user = userRepo.findByIdentity(string);
		return user;
	}

	@Override
	public User obtenirUserParEmail(String email) {

		User user = userRepo.findByUsername(email);
		return user;
	}

	@Override
	public void ajouterUser(User user) {
		userRepo.save(user);
		
	}

	@Override
	public void modifierUser(User user) {
		userRepo.save(user);
		
	}

	@Override
	public void supprimerUser(User user) {
		userRepo.delete(user);
		
	}

}
