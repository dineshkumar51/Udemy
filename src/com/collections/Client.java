package com.collections;

public abstract class Client

{
    abstract  public String getName();
    abstract  public void setName(String name);
    abstract  public void changePassword(String oldPassword, String newPassword) throws InvalidPasswordException;
    abstract public String getPassword();
}
