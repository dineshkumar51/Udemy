package com.collections;

public class UserIdAlreadyExistException extends Exception
{
    public UserIdAlreadyExistException(String string)
    {
        super(string);
    }

    public String getMessage()
    {

        return "UserId already exists";
    }

    public String toString()
    {
        return super.toString();
    }

}
