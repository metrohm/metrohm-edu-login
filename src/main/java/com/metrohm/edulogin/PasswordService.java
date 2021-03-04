package com.metrohm.edulogin;

import java.util.HashMap;
import java.util.Map;

/**
 * used for simple password validation with very ugly plain pw store!
 */
public class PasswordService {

    protected Map<String, String> passwordStore = new HashMap<>();

    public PasswordService() {
        this.passwordStore.put("bertold", "123456");
        this.passwordStore.put("franz", "password");
    }

    public PasswordService(Map<String, String> passwordStore) {
        this.passwordStore = passwordStore;
    }

    /**
     * checks if password for given user is valid.
     *
     * @param user     user name
     * @param password password.
     * @return true if pw is valid for user.
     */
    public boolean isValidPassword(String user, String password) {
        return passwordStore.containsKey(user) && passwordStore.get(user).equals(password);
    }
}
