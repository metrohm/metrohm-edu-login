package com.metrohm.edulogin.service;

/**
 * exception for invalid password.
 */
public class InvalidPasswordException extends RuntimeException {

    /**
     * creates exception for invalid pw for given user name.
     *
     * @param user user name.
     */
    public InvalidPasswordException(String user) {
        super("password for user " + user + " is invalid!");
    }
}
