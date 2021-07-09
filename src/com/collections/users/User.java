package com.collections.users;

import com.collections.exceptions.InvalidPasswordException;

public interface User

{
    int getId();

    void setId(int id);

    String getUserName();

    void setUserName(String userName);

    String getName();

    void setName(String name);

    void changePassword(String oldPassword, String newPassword) throws InvalidPasswordException;

    String getPassword();




}
