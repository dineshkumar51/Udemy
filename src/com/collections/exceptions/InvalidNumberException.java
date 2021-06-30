package com.collections.exceptions;

public class InvalidNumberException extends Exception
{
    public InvalidNumberException(String string)
    {
        super(string);
    }


    public String getMessage() {
        return "Invalid Number";
    }

    public String toString()
    {
        return super.toString();
    }



}
