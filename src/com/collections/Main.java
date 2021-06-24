package com.collections;

import com.sun.net.httpserver.Authenticator;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Udemy udemy = new Udemy();
        startUp(udemy);
        Scanner sc = new Scanner(System.in);

        while(true)
        {
            System.out.println("");
            System.out.println("1. LOGIN");
            System.out.println("2. SIGNUP");
            int check = sc.nextInt();

            if(check == 1)
            {
                Object obj = login(udemy);
                if(obj instanceof User )
                {
                    userLoggedIn((User)obj,udemy);
                }
                else if(obj instanceof Creator)
                {
                    creatorLoggedIn((Creator)obj,udemy);
                }
            }
            else
            {
                signUp(udemy);
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

    static void userLoggedIn(User user,Udemy udemy)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Buy a new Course");
        System.out.println("2.My Courses");
        System.out.println("3.Wishlist");
        int check = sc.nextInt();

        if(check == 1) {
            udemy.printCategories();
            System.out.println("");
            System.out.println("Enter a Category");

            int categoryId = sc.nextInt();
            Category category = udemy.getCategory(categoryId);
            category.printTopics();
            System.out.println("");
            System.out.println("Enter a Topic");

            int topicId = sc.nextInt();
            Topic topic = category.getTopic(topicId);
            topic.printCourses();


            System.out.print("Enter the CourseName : ");
            sc.nextLine();
            String courseName = sc.nextLine();
            Course selectedCourse = udemy.getCourse(courseName);
            System.out.println(selectedCourse);
            System.out.println("");
            System.out.println("1.Buy Now");
            System.out.println("2.Add to Wishlist");
            int check1 = sc.nextInt();
            if(check1 == 1)
            {
                udemy.buyCourse(courseName,user);
                System.out.println("All the Best ... continue learning");
            }
            else
            {
                user.addCourseToWishlist(udemy.getCourse(courseName));
                System.out.println("Course added to wishlist");
            }


        }
        else if(check == 2)
        {
            user.printMycourses();
        }
        else
        {
            user.printWishlist();
        }


    }

    static void creatorLoggedIn(Creator creator,Udemy udemy)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.View Summary");
        System.out.println("2.Create a Course");
        int check = sc.nextInt();

        if(check == 2) {
            udemy.printCategories();
            System.out.println("");
            System.out.println("Enter a Category");

            int categoryId = sc.nextInt();
            Category category = udemy.getCategory(categoryId);
            category.printTopics();
            System.out.println("");
            System.out.println("Enter a Topic");

            int topicId = sc.nextInt();
            Topic topic = category.getTopic(topicId);

            System.out.print("Enter your new CourseName : ");
            sc.nextLine();
            String courseName = sc.nextLine();
            udemy.createCourse(categoryId,topicId,creator.getCreatorId(),courseName);
            topic.printCourses();
            System.out.println("Course Created Successfully !!!");
            System.out.println("");

        }
        else
        {
            creator.printCreatedCourses();


        }


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
