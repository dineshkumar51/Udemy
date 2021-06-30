package com.collections;

public class PasswordMismatchException extends Exception
{



    public PasswordMismatchException(String string)
    {
        super(string);
    }

    public String getMessage() {

        return "Confirm password failed .... try again";
    }

    public String toString()
    {
        return super.toString();
    }

}
