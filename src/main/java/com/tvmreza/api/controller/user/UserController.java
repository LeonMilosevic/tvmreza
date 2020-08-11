package com.tvmreza.api.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tvmreza.api.entities.MyUserDetails;
import com.tvmreza.api.entities.User;
import com.tvmreza.api.security.utility.JWTTokenProvider;
import com.tvmreza.api.security.utility.SecurityConstant;
import com.tvmreza.api.services.user.UserService;

@Controller
@RequestMapping("/public/user")
public class UserController {

	private AuthenticationManager authenticationManager;
	private JWTTokenProvider tokenProvider;
	private UserService userService;

	@Autowired
	public UserController(AuthenticationManager authenticationManager, JWTTokenProvider tokenProvider,
			UserService userService) {
		super();
		this.authenticationManager = authenticationManager;
		this.tokenProvider = tokenProvider;
		this.userService = userService;
	}

	@PostMapping
	@RequestMapping("/register")
	public User registerUser(@RequestBody User user) {
		return userService.register(user.getFirstName(), user.getLastName(), user.getUsername());
	}

	@PostMapping
	@RequestMapping("/login")
	public ResponseEntity<User> loginUser(@RequestBody User user) {
		authenticate(user.getUsername(), user.getPassword());
		User loginUser = userService.findUserByUsername(user.getUsername());
		MyUserDetails myUserDetails = new MyUserDetails(loginUser);
		HttpHeaders jwtHeader = getJwtHeader(myUserDetails);
		return new ResponseEntity<>(loginUser, jwtHeader, HttpStatus.OK);
	}

	private HttpHeaders getJwtHeader(MyUserDetails myUserDetails) {
		HttpHeaders headers = new HttpHeaders();
		headers.add(SecurityConstant.JWT_TOKEN_HEADER, tokenProvider.generateJwtToken(myUserDetails));
		return headers;
	}

	private void authenticate(String username, String password) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	}
}
