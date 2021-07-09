package com.collections;

import com.collections.exceptions.InvalidUserIdOrPasswordException;
import com.collections.exceptions.PasswordMismatchException;
import com.collections.exceptions.UserIdAlreadyExistException;
import com.collections.udemy.Udemy;
import com.collections.users.*;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Main {

    public static void main(String[] args) {

        Udemy udemy = new Udemy();
        udemy.startUp();
        Scanner sc = new Scanner(System.in);

        while(true) {

            int check = 0;

                try
                {
                    System.out.println();
                    System.out.println("            1. LOGIN");
                    System.out.println("            2. SIGNUP");
                    check = sc.nextInt();
                }
                catch (InputMismatchException e)
                {
                    System.out.println("Enter a Valid option");
                    sc.nextLine();
                    continue;
                }

            if (check == 1) {
                User user = (User) login(udemy);
                if (user instanceof Learner) {
                    udemy.loggedInAsUser((Learner) user);
                } else if (user instanceof Creator) {
                    udemy.loggedInAsCreator((Creator) user);
                }
            } else if (check == 2) {
                signUp(udemy);
            } else {
                System.out.println("Enter a Valid option");
            }
        }


    }

    private static void signUp(Udemy udemy)
    {
        int flag = 0;
        while(flag < 1)
        {
            try {
                udemy.signup();
                flag++;
            }
            catch(UserIdAlreadyExistException e)
            {
                System.out.println(e);
                System.out.println();
            }
            catch (PasswordMismatchException e)
            {
                System.out.println(e);
                System.out.println();
            }
        }
    }

    private static Object login(Udemy udemy)
    {
        int flag = 0;
        Object obj = null;
        while(flag < 1)
        {
            try {
                obj = udemy.login();
                flag++;
            }
            catch(InvalidUserIdOrPasswordException e)
            {
                System.out.println(e);
                System.out.println();
            }

        }
        return obj;
    }

}
