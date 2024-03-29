package com.metrohm.edulogin.service;

import com.metrohm.edulogin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

/**
 * handle user actions.
 */
@Service
public class UserServiceImpl implements UserService{

    protected Map<String, User> users = new HashMap<>();
    protected final PasswordService passwordService;

    @Autowired
    public UserServiceImpl(PasswordService passwordService) {
        this.passwordService = passwordService;
        User bertold = new User();
        bertold.setUserName("bertold");
        bertold.setBirthDate(LocalDate.of(1955, Month.MARCH, 1));
        bertold.setHobby("Velo");
        User franz = new User();
        franz.setUserName("franz");
        franz.setBirthDate(LocalDate.of(1979, Month.NOVEMBER, 23));
        franz.setHobby("Langlauf");
        this.users.put(bertold.getUserName(), bertold);
        this.users.put(franz.getUserName(), franz);
    }

    @Override
    public User loadUser(String userName, String password) throws UserNotFoundException {
        if (!users.containsKey(userName)) {
            throw new UserNotFoundException();
        }
        if (!passwordService.isValidPassword(userName, password)) {
            throw new InvalidPasswordException(userName);
        }
        return users.get(userName);
    }
}
