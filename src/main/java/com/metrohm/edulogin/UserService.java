package com.metrohm.edulogin;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

/**
 * handle user actions.
 */
public class UserService {

    protected Map<String, User> users = new HashMap<>();
    protected PasswordService passwordService = new PasswordService();

    public UserService() {
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

    /**
     * loads user by username. password must be valid.
     *
     * @param userName username of user.
     * @param password password.
     * @return user if user exists and password is valid
     * @throws UserNotFoundException if user name not found.
     */
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
