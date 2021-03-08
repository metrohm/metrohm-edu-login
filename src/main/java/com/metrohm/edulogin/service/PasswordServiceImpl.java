package com.metrohm.edulogin.service;

import java.util.HashMap;
import java.util.Map;

/**
 * used for simple password validation with very ugly plain pw store!
 */
public class PasswordServiceImpl implements PasswordService {

	protected Map<String, String> passwordStore = new HashMap<>();

	public PasswordServiceImpl() {
		this.passwordStore.put("bertold", "123456");
		this.passwordStore.put("franz", "password");
	}

	public PasswordServiceImpl(Map<String, String> passwordStore) {
		this.passwordStore = passwordStore;
	}


	@Override
	public boolean isValidPassword(String user, String password) {
		return passwordStore.containsKey(user) && passwordStore.get(user).equals(password);
	}
}
