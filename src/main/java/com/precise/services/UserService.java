package com.precise.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.precise.models.entities.User;
import com.precise.models.repos.UserRepo;

@Service
@Transactional
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return userRepo.findByEmail(email).orElseThrow(
					()-> new UsernameNotFoundException(
							String.format("Email not found", email)
						)
				);
	}
	
	public User registerUser(User user) {
		boolean isExists = userRepo.findByEmail(user.getEmail()).isPresent();
		if(isExists) {
			throw new RuntimeException(
					String.format("Email exists", user.getEmail())
			);
		}
		
		String encodedPassword =  bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		return userRepo.save(user);
	}

}
