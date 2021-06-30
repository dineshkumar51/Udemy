package com.collections.exceptions;

public class InvalidPasswordException extends Exception
{


    public InvalidPasswordException(String string)
    {
        super(string);
    }

    public String getMessage() {
        return "Incorrect Password";
    }

    public String toString()
    {
        return super.toString();
    }
}
