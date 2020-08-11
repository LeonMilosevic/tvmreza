package com.tvmreza.api.services.user;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tvmreza.api.entities.MyUserDetails;
import com.tvmreza.api.entities.User;
import com.tvmreza.api.repositories.UserRepository;

@Service
@Transactional
@Qualifier("UserDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findUserByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Credentials are wrong, please try again");
		} else {
			return new MyUserDetails(user);
		}

	}

	@Override
	public User register(String firstName, String lastName, String username) {
		User user = new User();
		String password = "XeGyZp2UyCsOw4z5suKJh7TiFl2Bc2zr";
		String encodedPassword = passwordEncoder.encode(password);
		user.setFirstName("Mustafa");
		user.setLastName("Skenderi");
		user.setUsername("Administrator");
		user.setPassword(encodedPassword);
		user.setRole("ROLE_ADMIN");
		return userRepository.save(user);
	}

	@Override
	public User findUserByUsername(String username) {
		return userRepository.findUserByUsername(username);
	}
}
