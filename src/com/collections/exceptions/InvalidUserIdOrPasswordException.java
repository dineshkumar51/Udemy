package com.collections.exceptions;

public class InvalidUserIdOrPasswordException extends Exception
{

    public InvalidUserIdOrPasswordException(String string)
    {
        super(string);
    }

    public String getMessage()
    {
        return "Incorrect UserId or Password";
    }

    public String toString()
    {
        return super.toString();
    }


}
