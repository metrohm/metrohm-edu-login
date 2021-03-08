package com.metrohm.edulogin.service;

import com.metrohm.edulogin.model.User;

/**
 * UserService
 *
 * @author lorenzboesch, Metrohm AG
 * @since 08.03.21 16:37
 */
public interface UserService {

	/**
	 * loads user by username. password must be valid.
	 *
	 * @param userName username of user.
	 * @param password password.
	 * @return user if user exists and password is valid
	 * @throws UserNotFoundException if user name not found.
	 */
	User loadUser(String userName, String password) throws UserNotFoundException;
}
