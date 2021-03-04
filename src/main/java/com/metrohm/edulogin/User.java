package com.metrohm.edulogin;

import java.time.LocalDate;

public class User {

    private String userName;

    private LocalDate birthDate;

    private String hobby;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", birthDate=" + birthDate +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
