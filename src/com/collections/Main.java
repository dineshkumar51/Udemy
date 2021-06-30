package com.collections;



import java.util.*;

public class Main {

    public static void main(String[] args) {

        Udemy udemy = new Udemy();
        startUp(udemy);
        Scanner sc = new Scanner(System.in);

        while(true) {

            int check = 0;

                try
                {
                    System.out.println("");
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

                switch (check) {
                case 1:
                {
                    Client client = (Client) login(udemy);
                    if (client instanceof User) {
                        udemy.loggedInAsUser((User) client);
                    } else if (client instanceof Creator) {
                        udemy.loggedInAsCreator((Creator) client);
                    }
                }
                break;

                case 2:
                {
                    signUp(udemy);
                }
                break;

                default:System.out.println("Enter a Valid option");
                    break;
            }
        }


    }

    static void signUp(Udemy udemy)
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
                System.out.println("");
            }
            catch (PasswordMismatchException e)
            {
                System.out.println(e);
                System.out.println("");
            }
        }
    }

    static Object login(Udemy udemy)
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
                System.out.println("");
            }

        }
        return obj;
    }





    static void startUp(Udemy udemy)
    {
        udemy.test();
        udemy.addCategory(1,"Development");
        udemy.addCategory(2,"Business");
        udemy.addCategory(3,"IT & Software");
        udemy.addCategory(4,"Marketing");

        udemy.getCategory(1).addTopic(1,"Web Development");
        udemy.getCategory(1).addTopic(2,"Data Science");

        udemy.getCategory(2).addTopic(1,"Management");
        udemy.getCategory(2).addTopic(2,"Sales");

        udemy.createCourse(1,1,"kumar123","Web Development Bootcamp");
        udemy.createCourse(1,1,"kumar123","The Complete JavaScript");
        udemy.createCourse(1,1,"kumar123","React - The Complete Guide");

        udemy.createCourse(1,2,"kumar123","Python for Datascience");
        udemy.createCourse(1,2,"kumar123","Machine Learning A-Z");
        udemy.createCourse(1,2,"kumar123","Deep Learning A-Z");





    }

}
