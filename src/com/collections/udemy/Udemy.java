package com.collections.udemy;

import com.collections.exceptions.UserIdAlreadyExistException;
import com.collections.exceptions.PasswordMismatchException;
import com.collections.exceptions.InvalidNumberException;
import com.collections.exceptions.InvalidUserIdOrPasswordException;
import com.collections.users.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Udemy

{
        private final HashMap<String, Learner> users;
        private final HashMap<String, Creator> instructors;
        private final HashMap<Integer, Course> allCourses;
        private final HashMap<Integer, Category> categories;
        private final HashMap<Integer, Creator> instructorIds;


        public Udemy() {
                users = new HashMap<>();
                instructors = new HashMap<>();
                categories = new HashMap<>();
                allCourses = new HashMap<>();
                instructorIds = new HashMap<>();
        }

        public User login() throws InvalidUserIdOrPasswordException
        {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter your UserName : ");
                String userId = sc.next();
                System.out.print("Enter your Password : ");
                String password = sc.next();

                if (users.containsKey(userId)) {
                        String correctPassword = users.get(userId).getPassword();
                        if (correctPassword.equals(password)) {
                                System.out.println("Welcome, " + users.get(userId).getName());
                                return users.get(userId);
                        }
                }

                else if (instructors.containsKey(userId)) {
                        String correctPassword = instructors.get(userId).getPassword();
                        if (correctPassword.equals(password)) {
                                System.out.println("Welcome, " + instructors.get(userId).getName());
                                return instructors.get(userId);
                        }
                }

                throw new InvalidUserIdOrPasswordException("Incorrect UserId or Password");


        }

        public void signup() throws UserIdAlreadyExistException,PasswordMismatchException {
                Scanner sc = new Scanner(System.in);
                boolean signUpFlag = true;
                int signUpOption = 0;
                while(signUpFlag)
                {
                        try
                        {
                                System.out.println("            1.SignUp as User");
                                System.out.println("            2.SignUp as Creator");

                                signUpOption = sc.nextInt();
                                if(signUpOption>0 && signUpOption<3)
                                {
                                        signUpFlag = false;
                                }
                                System.out.println("Enter a Valid option");
                                System.out.println();
                        }
                        catch (InputMismatchException e)
                        {
                                System.out.println("Enter a Valid option");
                                System.out.println();
                                sc.nextLine();
                        }

                }

                switch (signUpOption) {
                        case 1 -> {
                                System.out.print("Enter your name : ");
                                sc.nextLine();
                                String name = sc.nextLine();
                                System.out.print("Enter userId : ");
                                String userId = sc.next();
                                System.out.print("Enter password : ");
                                String password = sc.next();
                                System.out.print("Confirm password : ");
                                String confirmPassword = sc.next();

                                if (!password.equals(confirmPassword)) {
                                        throw new PasswordMismatchException("Confirm password failed .... try again");
                                }

                                if (!users.containsKey(userId)) {
                                        Learner newLearner = new Learner(name, password, userId);
                                        users.put(userId, newLearner);
                                        System.out.println("Account Created Successfully");
                                } else {
                                        throw new UserIdAlreadyExistException("UserId already exists");
                                }

                        }
                        case 2 -> {
                                System.out.print("Enter your name : ");
                                sc.nextLine();
                                String name = sc.nextLine();
                                System.out.print("Enter creatorId : ");
                                String creatorId = sc.next();
                                System.out.print("Enter password : ");
                                String password = sc.next();

                                System.out.print("Confirm password : ");
                                String confirmPassword = sc.next();

                                if (!password.equals(confirmPassword)) {
                                        throw new PasswordMismatchException("Confirm password failed .... try again");
                                }


                                if (!instructors.containsKey(creatorId)) {
                                        Creator newCreator = new Creator(name, password, creatorId);
                                        instructors.put(creatorId, newCreator);
                                        instructorIds.put(newCreator.getId(), newCreator);
                                        System.out.println("Account Created Successfully");

                                } else {

                                        throw new UserIdAlreadyExistException("UserId already exists");
                                }


                        }
                        default -> System.out.println("Enter a Valid option");
                }
        }

        public void loggedInAsUser(Learner learner) {

                boolean homePageFlag = true;
                while(homePageFlag)
                {
                        Scanner sc = new Scanner(System.in);
                        System.out.println();
                        System.out.println("HOME PAGE");
                        System.out.println();
                        System.out.println("            1.Buy a new Course");
                        System.out.println("            2.My Courses");
                        System.out.println("            3.Wishlist");
                        System.out.println("            4.Rate a Course");
                        System.out.println("            5.Log Out");
                        int homePageOption;
                        try
                        {
                                homePageOption = sc.nextInt();
                        }
                        catch (InputMismatchException e)
                        {
                                System.out.println("Kindly Enter a valid option");
                                System.out.println();
                                sc.nextLine();
                                continue;
                        }


                        switch (homePageOption) {

                                case 1 -> {
                                        int searchOption =0;
                                        boolean searchFlag = true;
                                        while (searchFlag) {
                                                System.out.println("            1.Search by categories");
                                                System.out.println("            2.Search by Instructors");


                                                try {
                                                        searchOption = sc.nextInt();
                                                        searchFlag = false;
                                                } catch (InputMismatchException e) {
                                                        System.out.println("Kindly Enter a valid option");
                                                        System.out.println();
                                                        sc.nextLine();
                                                }
                                        }

                                        if (searchOption == 1) {
                                                Category category = null;
                                                boolean categoryFlag = true;
                                                while (categoryFlag) {
                                                        try {
                                                                printCategories();
                                                                System.out.println();
                                                                System.out.println("Enter a Category");

                                                                int categoryId = sc.nextInt();
                                                                category = getCategory(categoryId);
                                                                categoryFlag = false;
                                                        } catch (NullPointerException e) {
                                                                System.out.println("Kindly Enter a valid option");
                                                                System.out.println();
                                                        } catch (InputMismatchException e) {
                                                                System.out.println("Kindly Enter a valid option");
                                                                System.out.println();
                                                                sc.nextLine();
                                                        }

                                                }

                                                Topic topic = null;
                                                boolean topicFlag = true;
                                                while (topicFlag) {
                                                        try {
                                                                category.printTopics();
                                                                System.out.println();
                                                                System.out.println("Enter a Topic");
                                                                int topicId = sc.nextInt();
                                                                topic = category.getTopic(topicId);
                                                                topicFlag = false;
                                                        } catch (NullPointerException e) {
                                                                System.out.println("Kindly Enter a valid option");
                                                                System.out.println();
                                                        } catch (InputMismatchException e) {
                                                                System.out.println("Kindly Enter a valid option");
                                                                System.out.println();
                                                                sc.nextLine();
                                                        }

                                                }

                                                Course selectedCourse = null;
                                                int courseId = 0;
                                                boolean courseFlag = true;
                                                while (courseFlag) {
                                                        try {
                                                                topic.printCourses();
                                                                System.out.print("Enter the CourseId : ");
                                                                sc.nextLine();
                                                                courseId = sc.nextInt();
                                                                selectedCourse = getCourse(courseId);
                                                                courseFlag = false;
                                                        } catch (NullPointerException e) {
                                                                System.out.println("Kindly Enter a valid Course Id");
                                                                System.out.println();
                                                        } catch (InputMismatchException e) {
                                                                System.out.println("Kindly Enter a valid option");
                                                                System.out.println();
                                                                sc.nextLine();
                                                        }


                                                }

                                                System.out.println(selectedCourse);
                                                boolean CourseOptionFlag = true;
                                                while (CourseOptionFlag) {
                                                        System.out.println();
                                                        System.out.println("1.Buy Now");
                                                        System.out.println("2.Add to Wishlist");
                                                        int courseOption = sc.nextInt();
                                                        if (courseOption == 1) {
                                                                buyCourse(courseId, learner);
                                                                System.out.println("All the Best ... continue learning");
                                                                CourseOptionFlag = false;
                                                        } else if (courseOption == 2) {
                                                                learner.addCourseToWishlist(getCourse(courseId));
                                                                System.out.println("Course added to wishlist");
                                                                break;
                                                        } else {
                                                                System.out.println("Enter a valid Option");
                                                        }
                                                }
                                        } else if (searchOption == 2) {

                                                Creator creator = null;
                                                int creatorId = 0;
                                                boolean clearBuffer = true;
                                                boolean searchByInstructorFlag = true;
                                                while (searchByInstructorFlag) {

                                                        printInstructors();
                                                        System.out.print("Enter a Instructor Id : ");
                                                        if (clearBuffer)
                                                                sc.nextLine();
                                                        creatorId = sc.nextInt();
                                                        creator = instructorIds.get(creatorId);
                                                        if (creator == null) {
                                                                System.out.println("Kindly Enter a valid Instructor Id");
                                                                System.out.println();
                                                                clearBuffer = false;
                                                                continue;
                                                        }
                                                        System.out.println();
                                                        searchByInstructorFlag = false;

                                                }

                                                Course selectedCourse = null;
                                                int courseId = 0;
                                                boolean courseFlag = true;
                                                while (courseFlag) {
                                                        try {
                                                                creator.printCourses();
                                                                System.out.print("Enter the CourseId : ");
                                                                //sc.nextLine();
                                                                courseId = sc.nextInt();
                                                                selectedCourse = getCourse(courseId);
                                                                courseFlag = false;
                                                        } catch (NullPointerException e) {
                                                                System.out.println("Kindly Enter a valid Course Id\n");

                                                        } catch (InputMismatchException e) {
                                                                System.out.println("Kindly Enter a valid option\n");
                                                                sc.nextLine();
                                                        }


                                                }

                                                System.out.println(selectedCourse);
                                                boolean courseOptionFlag = true;
                                                while (courseOptionFlag) {
                                                        System.out.println();
                                                        System.out.println("1.Buy Now");
                                                        System.out.println("2.Add to Wishlist");
                                                        int courseOption = sc.nextInt();
                                                        if (courseOption == 1) {
                                                                buyCourse(courseId, learner);
                                                                System.out.println("All the Best ... continue learning");
                                                                courseOptionFlag = false;
                                                        } else if (courseOption == 2) {
                                                                learner.addCourseToWishlist(getCourse(courseId));
                                                                System.out.println("Course added to wishlist");
                                                                courseOptionFlag = false;
                                                        } else {
                                                                System.out.println("Enter a valid Option");
                                                        }
                                                }
                                        } else {
                                                System.out.println("Enter a Valid option");
                                        }


                                }
                                case 2 -> learner.printCourses();

                                case 3 -> learner.printWishlist();


                                case 4 -> {
                                        Course course = null;
                                        int courseId = 0;
                                        boolean courseFlag = true;
                                        while (courseFlag) {
                                                try {
                                                        learner.printCourses();
                                                        System.out.print("Enter a Course Id : ");
                                                        sc.nextLine();
                                                        courseId = sc.nextInt();
                                                        course = allCourses.get(courseId);
                                                        if (course == null) {
                                                                throw new NullPointerException();
                                                        }
                                                        courseFlag = false;
                                                } catch (NullPointerException e) {
                                                        System.out.println("Kindly Enter a valid Course Id");
                                                        System.out.println();
                                                } catch (InputMismatchException e) {
                                                        System.out.println("Kindly Enter a valid option");
                                                        System.out.println();
                                                        sc.nextLine();
                                                }

                                        }
                                        float rating;
                                        boolean RatingFlag = true;
                                        while (RatingFlag) {
                                                try {
                                                        System.out.print("Provide your rating (1--5) : ");
                                                        rating = (float)sc.nextFloat();
                                                        course.setRating(rating);
                                                        RatingFlag = false;
                                                } catch (InvalidNumberException e) {
                                                        System.out.println("Kindly Enter a valid option");
                                                        System.out.println();
                                                } catch (InputMismatchException e) {
                                                        System.out.println("Kindly Enter a valid option");
                                                        System.out.println();
                                                        sc.nextLine();
                                                }

                                        }

                                }
                                case 5 -> homePageFlag = false;
                                default -> System.out.println("Enter a Valid option");
                        }
                }

        }

        public void loggedInAsCreator(Creator creator)
        {
                boolean homePageFlag = true;
                while(homePageFlag)
                {
                        Scanner sc = new Scanner(System.in);
                        System.out.println();
                        System.out.println("HOME PAGE");
                        System.out.println("            1.create a Course");
                        System.out.println("            2.View Summary");
                        System.out.println("            3.Log Out");
                        int homePageOption;
                        try
                        {
                                homePageOption = sc.nextInt();
                        }
                        catch (InputMismatchException e)
                        {
                                System.out.println("Kindly Enter a valid option");
                                System.out.println();
                                continue;
                        }

                        switch (homePageOption) {
                                case 1 -> {
                                        Category category = null;
                                        int categoryId = 0;
                                        boolean categoryFlag = true;
                                        while (categoryFlag) {

                                                try {
                                                        printCategories();
                                                        System.out.println();
                                                        System.out.println("Enter a Category");

                                                        categoryId = sc.nextInt();
                                                        category = getCategory(categoryId);
                                                        categoryFlag = false;
                                                } catch (NullPointerException e) {
                                                        System.out.println("Kindly Enter a valid option");
                                                        System.out.println();
                                                } catch (InputMismatchException e) {
                                                        System.out.println("Kindly Enter a valid option");
                                                        System.out.println();
                                                        sc.nextLine();
                                                }


                                        }

                                        int topicId = 0;
                                        Topic topic = null;
                                        boolean topicFlag = true;
                                        while (topicFlag) {
                                                try {
                                                        category.printTopics();
                                                        System.out.println();
                                                        System.out.println("Enter a Topic");

                                                        topicId = sc.nextInt();
                                                        topic = category.getTopic(topicId);
                                                        topicFlag = false;

                                                } catch (NullPointerException e) {
                                                        System.out.println("Kindly Enter a valid option");
                                                        System.out.println();
                                                } catch (InputMismatchException e) {
                                                        System.out.println("Kindly Enter a valid option");
                                                        System.out.println();
                                                        sc.nextLine();
                                                }

                                        }

                                        String courseName;
                                        System.out.print("Enter your new CourseName : ");
                                        sc.nextLine();
                                        courseName = sc.nextLine();
                                        createCourse(categoryId, topicId, creator.getUserName(), courseName);
                                        topic.printCourses();
                                        System.out.println("Course Created Successfully !!!");
                                        System.out.println();
                                }
                                case 2 -> creator.printCourses();
                                case 3 -> homePageFlag = false;
                                default -> System.out.println("Enter a Valid option");
                        }
                }

        }

        private Creator getCreator(String creatorId)
        {
                return instructors.get(creatorId);
        }


        private void addCategory(Integer id,String name)
        {
                categories.put(id,new Category(name));
        }


        private Category getCategory(int index)
        {
                Category category= categories.get(index);
                if(category == null)
                        throw new NullPointerException();
                return category;

        }

        private Course getCourse(int Id)
        {
                Course course =  allCourses.get(Id);
                if(course == null)
                {
                        throw new NullPointerException();
                }
                return course;
        }

        private void printCategories()
        {
                System.out.println("CATEGORIES");
                categories.forEach((key, value) -> System.out.println("            " + key + ". " + value));
        }


        private void printInstructors()
        {
                System.out.println("INSTRUCTORS");
                instructorIds.forEach((key, value) -> System.out.println("            " + key + ". " + value));
        }





        private void createCourse(int categoryId,int topicId,String creatorId,String name)
        {
                Creator creator = getCreator(creatorId);
                Course newCourse = getCategory(categoryId).getTopic(topicId).addCourse(name,creator,topicId,categoryId);
                int courseId = newCourse.getId();
                allCourses.put(newCourse.getId(), newCourse);
                creator.addToCourses(newCourse,courseId);

        }


        private void buyCourse(int courseId, Learner learner)
        {
                Course newCourse = allCourses.get(courseId);
                newCourse.incrementNumberOfUsers();
                learner.addToCourses(newCourse);
        }



        public void startUp()
        {
                users.put("dinesh123",new Learner("Dinesh","qwer","dinesh123"));
                users.put("ram123",new Learner("Ram","ram123","ram123"));
                Creator creator = new Creator("kumar","5151","kumar123");
                instructors.put("kumar123",creator);
                instructorIds.put(creator.getId(),creator);


                addCategory(1,"Development");
                addCategory(2,"Business");
                addCategory(3,"IT & Software");
                addCategory(4,"Marketing");

                getCategory(1).addTopic(1,"Web Development");
                getCategory(1).addTopic(2,"Data Science");

                getCategory(2).addTopic(1,"Management");
                getCategory(2).addTopic(2,"Sales");

                createCourse(1,1,"kumar123","Web Development Bootcamp");
                createCourse(1,1,"kumar123","The Complete JavaScript");
                createCourse(1,1,"kumar123","React - The Complete Guide");

                createCourse(1,2,"kumar123","Python for Datascience");
                createCourse(1,2,"kumar123","Machine Learning A-Z");
                createCourse(1,2,"kumar123","Deep Learning A-Z");

        }
}


