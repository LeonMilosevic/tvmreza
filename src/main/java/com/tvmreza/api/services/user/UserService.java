package com.tvmreza.api.services.user;

import com.tvmreza.api.entities.User;

public interface UserService {
	User register(String firstName, String lastName, String username);

	User findUserByUsername(String username);
}
