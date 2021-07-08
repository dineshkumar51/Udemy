package com.collections;

import com.collections.exceptions.InvalidPasswordException;

public abstract class User

{
    abstract  public String getName();
    abstract  public void setName(String name);
    abstract  public void changePassword(String oldPassword, String newPassword) throws InvalidPasswordException, InvalidPasswordException;
    abstract public String getPassword();
}
