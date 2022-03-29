package com.metrohm.edulogin.service;

import com.metrohm.edulogin.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

/**
 * UserServiceTest
 *
 * @author lorenzboesch, Metrohm AG
 * @since 08.03.21 14:22
 */
class UserServiceTest {
	@Test
	public void loadUser() throws Exception {
		//create mock
		PasswordService passwordService = mock(PasswordService.class);
		//given
		UserServiceImpl userService = new UserServiceImpl(passwordService);
		//record behavior
		when(passwordService.isValidPassword("bertold", "pw")).thenReturn(true);
		//when
		User user = userService.loadUser("bertold", "pw");
		//then
		assertEquals("bertold", user.getUserName());
		assertEquals("Velo", user.getHobby());
	}

	@Test
	public void loadUserUnknown() throws Exception {
		//create mock
		PasswordService passwordService = mock(PasswordService.class);
		//given
		UserServiceImpl userService = new UserServiceImpl(passwordService);
		//when
		assertThrows(UserNotFoundException.class, ()->userService.loadUser("not-known", "pw"));
		//then
		verifyNoInteractions(passwordService);
	}

	@Test
	public void loadUserWrongPassword() throws Exception {
		//create mock
		PasswordService passwordService = mock(PasswordService.class);
		//given
		UserServiceImpl userService = new UserServiceImpl(passwordService);
		//record behavior
		when(passwordService.isValidPassword("bertold", "pw")).thenReturn(false);
		//when
		assertThrows(InvalidPasswordException.class, ()->userService.loadUser("bertold", "pw"));
		//then
		verify(passwordService).isValidPassword("bertold", "pw");
	}
}
