package com.metrohm.edulogin.service;

/**
 * PasswordService
 *
 * @author lorenzboesch, Metrohm AG
 * @since 08.03.21 16:37
 */
public interface PasswordService {

	/**
	 * checks if password for given user is valid.
	 *
	 * @param user     user name
	 * @param password password.
	 * @return true if pw is valid for user.
	 */
	boolean isValidPassword(String user, String password);
}
