package com.metrohm.edulogin.service;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * PasswordServiceTest
 *
 * @author lorenzboesch, Metrohm AG
 * @since 02.03.21 10:55
 */
class PasswordServiceTest {
	@Test
	void isValidPasswordUserNotFound() {
		//given
		Map<String, String> passwordStore = new HashMap<>();
		PasswordServiceImpl service = new PasswordServiceImpl(passwordStore);
		//when
		boolean validPassword = service.isValidPassword("test", "test");
		//then
		assertFalse(validPassword);
	}

	@Test
	void isValidPasswordWrongPw() {
		//given
		Map<String, String> passwordStore = new HashMap<>();
		passwordStore.put("tester", "safe");
		PasswordServiceImpl service = new PasswordServiceImpl(passwordStore);
		//when
		boolean validPassword = service.isValidPassword("tester", "test");
		//then
		assertFalse(validPassword);
	}

	@Test
	void isValidPassword() {
		//given
		Map<String, String> passwordStore = new HashMap<>();
		passwordStore.put("tester", "safe");
		PasswordServiceImpl service = new PasswordServiceImpl(passwordStore);
		//when
		boolean validPassword = service.isValidPassword("tester", "safe");
		//then
		assertTrue(validPassword);
	}
}