package com.collections;

import java.util.*;

public class Udemy
{
        private HashMap<String,User> users;
        private HashMap<String,Creator> instructors;
        private HashMap<String,Course> allCourses;
        private HashMap<Integer,Category> categories;
        private HashMap<String,String> instructorNames;


        public Udemy() {
                users = new HashMap<>();
                instructors = new HashMap<>();
                categories = new HashMap<>();
                allCourses = new HashMap<>();
                instructorNames = new HashMap<>();
        }

        public Object login() throws InvalidUserIdOrPasswordException
        {
                Scanner sc = new Scanner(System.in);
                int loginOption;
                while(true)
                {
                        try
                        {
                                System.out.println("            1.Login as User");
                                System.out.println("            2.Login as Creator");

                                loginOption = sc.nextInt();
                                if(loginOption>0 && loginOption<3)
                                {
                                        break;
                                }
                                System.out.println("Enter a Valid option");
                                System.out.println("");
                        }
                        catch (InputMismatchException e)
                        {
                                System.out.println("Enter a Valid option");
                                System.out.println("");
                                sc.nextLine();
                        }

                }



                switch (loginOption) {
                        case 1:
                        {
                                System.out.print("Enter your UserId : ");
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
                                //sc.close();
                                throw new InvalidUserIdOrPasswordException();

                        }

                        case 2: {
                                System.out.print("Enter your CreatorId : ");
                                String creatorId = sc.next();
                                System.out.print("Enter your Password : ");
                                String password = sc.next();

                                if (instructors.containsKey(creatorId)) {
                                        String correctPassword = instructors.get(creatorId).getPassword();
                                        if (correctPassword.equals(password)) {
                                                System.out.println("Welcome, " + instructors.get(creatorId).getName());
                                                return instructors.get(creatorId);
                                        }
                                }
                                //sc.close();
                                throw new InvalidUserIdOrPasswordException();
                        }

                        default: System.out.println("Enter a Valid option");
                        break;

                }
                return new Object();

        }

        public void signup() throws UserIdAlreadyExistException,PasswordMismatchException {
                Scanner sc = new Scanner(System.in);
                int signUpOption;


                while(true)
                {
                        try
                        {
                                System.out.println("            1.SignUp as User");
                                System.out.println("            2.SignUp as Creator");

                                signUpOption = sc.nextInt();
                                if(signUpOption>0 && signUpOption<3)
                                {
                                        break;
                                }
                                System.out.println("Enter a Valid option");
                                System.out.println("");
                        }
                        catch (InputMismatchException e)
                        {
                                System.out.println("Enter a Valid option");
                                System.out.println("");
                                sc.nextLine();
                        }

                }

                switch (signUpOption) {
                        case 1: {
                                System.out.print("Enter your name : ");
                                sc.nextLine();
                                String name = sc.nextLine();
                                System.out.print("Enter userId : ");
                                String userId = sc.next();
                                System.out.print("Enter password : ");
                                String password = sc.next();
                                System.out.print("Confirm password : ");
                                String confirmPassword = sc.next();

                                if(! password.equals(confirmPassword))
                                {
                                        throw new PasswordMismatchException();
                                }

                                if (!users.containsKey(userId)) {
                                        User newUser = new User(name, password, userId);
                                        users.put(userId, newUser);
                                        System.out.println("Account Created Successfully");
                                } else {
                                        //sc.close();
                                        throw new UserIdAlreadyExistException();
                                }

                        }
                        break;

                        case 2: {
                                System.out.print("Enter your name : ");
                                sc.nextLine();
                                String name = sc.nextLine();
                                System.out.print("Enter creatorId : ");
                                String creatorId = sc.next();
                                System.out.print("Enter password : ");
                                String password = sc.next();

                                System.out.print("Confirm password : ");
                                String confirmPassword = sc.next();

                                if(! password.equals(confirmPassword))
                                {
                                        throw new PasswordMismatchException();
                                }


                                if (!instructors.containsKey(creatorId)) {
                                        Creator newCreator = new Creator(name, password, creatorId);
                                        instructors.put(creatorId, newCreator);
                                        instructorNames.put(name,creatorId);
                                        System.out.println("Account Created Successfully");

                                } else {
                                        //sc.close();
                                        throw new UserIdAlreadyExistException();
                                }


                        }
                        break;

                        default: System.out.println("Enter a Valid option");
                        break;


                }
        }

        public void loggedInAsUser(User user) {

                boolean flag = true;
                while(flag)
                {
                        Scanner sc = new Scanner(System.in);
                        System.out.println("");
                        System.out.println("HOME PAGE");
                        System.out.println("");
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
                                System.out.println("");
                                sc.nextLine();
                                continue;
                        }


                        switch (homePageOption) {
                                case 1:
                                {
                                        int searchOption;
                                        while(true) {
                                                System.out.println("            1.Search by categories");
                                                System.out.println("            2.Search by Instructors");


                                                try {
                                                        searchOption = sc.nextInt();
                                                        break;
                                                } catch (InputMismatchException e) {
                                                        System.out.println("Kindly Enter a valid option");
                                                        System.out.println("");
                                                        sc.nextLine();
                                                }
                                        }

                                        if(searchOption == 1) {
                                                Category category;
                                                while (true) {
                                                        try {
                                                                printCategories();
                                                                System.out.println("");
                                                                System.out.println("Enter a Category");

                                                                int categoryId = sc.nextInt();
                                                                category = getCategory(categoryId);
                                                                break;
                                                        } catch (NullPointerException e) {
                                                                System.out.println("Kindly Enter a valid option");
                                                                System.out.println("");
                                                        } catch (InputMismatchException e) {
                                                                System.out.println("Kindly Enter a valid option");
                                                                System.out.println("");
                                                                sc.nextLine();
                                                        }

                                                }

                                                Topic topic;
                                                while (true) {
                                                        try {
                                                                category.printTopics();
                                                                System.out.println("");
                                                                System.out.println("Enter a Topic");

                                                                int topicId = sc.nextInt();
                                                                topic = category.getTopic(topicId);
                                                                break;
                                                        } catch (NullPointerException e) {
                                                                System.out.println("Kindly Enter a valid option");
                                                                System.out.println("");
                                                        } catch (InputMismatchException e) {
                                                                System.out.println("Kindly Enter a valid option");
                                                                System.out.println("");
                                                                sc.nextLine();
                                                        }

                                                }

                                                Course selectedCourse;
                                                String courseName;
                                                while (true) {
                                                        try {
                                                                topic.printCourses();
                                                                System.out.print("Enter the CourseName : ");
                                                                sc.nextLine();
                                                                courseName = sc.nextLine();
                                                                selectedCourse = getCourse(courseName);
                                                                break;
                                                        } catch (NullPointerException e) {
                                                                System.out.println("Kindly Enter a valid Course name");
                                                                System.out.println("");
                                                        } catch (InputMismatchException e) {
                                                                System.out.println("Kindly Enter a valid option");
                                                                System.out.println("");
                                                                sc.nextLine();
                                                        }


                                                }

                                                System.out.println(selectedCourse);

                                                while (true) {
                                                        System.out.println("");
                                                        System.out.println("1.Buy Now");
                                                        System.out.println("2.Add to Wishlist");
                                                        int courseOption = sc.nextInt();
                                                        if (courseOption == 1) {
                                                                buyCourse(courseName, user);
                                                                System.out.println("All the Best ... continue learning");
                                                                break;
                                                        } else if (courseOption == 2) {
                                                                user.addCourseToWishlist(getCourse(courseName));
                                                                System.out.println("Course added to wishlist");
                                                                break;
                                                        } else {
                                                                System.out.println("Enter a valid Option");
                                                        }
                                                }
                                        }
                                        else if(searchOption == 2)
                                        {

                                              Creator creator;
                                              String creatorName;
                                              int flag1 = 0;
                                              while(true)
                                              {

                                                      printInstructors();
                                                      System.out.print("Enter a Instructor Name : ");
                                                      if(flag1 == 0)
                                                                sc.nextLine();
                                                      creatorName = sc.nextLine();
                                                      creator = instructors.get(instructorNames.get(creatorName));
                                                      if(creator == null)
                                                      {
                                                              System.out.println("Kindly Enter a valid Instructor name");
                                                              System.out.println("");
                                                              flag1 = 1;
                                                              continue;
                                                      }
                                                      System.out.println("");
                                                      break;

                                              }

                                                Course selectedCourse;
                                                String courseName;
                                                while (true) {
                                                        try {
                                                                creator.printCreatedCourses();
                                                                System.out.print("Enter the CourseName : ");
                                                                //sc.nextLine();
                                                                courseName = sc.nextLine();
                                                                selectedCourse = getCourse(courseName);
                                                                break;
                                                        } catch (NullPointerException e) {
                                                                System.out.println("Kindly Enter a valid Course name");
                                                                System.out.println("");
                                                        } catch (InputMismatchException e) {
                                                                System.out.println("Kindly Enter a valid option");
                                                                System.out.println("");
                                                                sc.nextLine();
                                                        }


                                                }

                                                System.out.println(selectedCourse);

                                                while (true) {
                                                        System.out.println("");
                                                        System.out.println("1.Buy Now");
                                                        System.out.println("2.Add to Wishlist");
                                                        int courseOption = sc.nextInt();
                                                        if (courseOption == 1) {
                                                                buyCourse(courseName, user);
                                                                System.out.println("All the Best ... continue learning");
                                                                break;
                                                        } else if (courseOption == 2) {
                                                                user.addCourseToWishlist(getCourse(courseName));
                                                                System.out.println("Course added to wishlist");
                                                                break;
                                                        } else {
                                                                System.out.println("Enter a valid Option");
                                                        }
                                                }
                                        }
                                        else
                                        {
                                                System.out.println("Enter a Valid option");
                                        }


                                }
                                break;


                                case 2:
                                {
                                        user.printMycourses();
                                }
                                break;


                                case 3:
                                {
                                        user.printWishlist();
                                }
                                break;

                                case 4:
                                {
                                        Course course;
                                        String courseName;
                                        while(true)
                                        {
                                                try
                                                {
                                                        user.printMycourses();
                                                        System.out.print("Enter a Course Name : ");
                                                        sc.nextLine();
                                                        courseName = sc.nextLine();
                                                        course = allCourses.get(courseName);
                                                        if(course == null)
                                                        {
                                                                throw new NullPointerException();
                                                        }
                                                        break;
                                                }
                                                catch (NullPointerException e)
                                                {
                                                        System.out.println("Kindly Enter a valid Course name");
                                                        System.out.println("");
                                                }
                                                catch (InputMismatchException e)
                                                {
                                                        System.out.println("Kindly Enter a valid option");
                                                        System.out.println("");
                                                        sc.nextLine();
                                                }

                                        }
                                        float rating;
                                        Topic topic;
                                        Creator creator;
                                        while(true)
                                        {
                                                try
                                                {
                                                        topic = categories.get(course.getCategoryId()).getTopic(course.getTopicId());
                                                        topic.removeCourse(course);
                                                        creator = course.getCreator();
                                                        creator.removeFromCreatedCourses(course);
                                                        System.out.print("Provide your rating (1--5) : ");
                                                        rating = (float)sc.nextFloat();
                                                        course.setRating(rating);
                                                        break;
                                                }
                                                catch (InvalidNumberException e)
                                                {
                                                        System.out.println("Kindly provide  rating only between (1--5)");
                                                        System.out.println("");
                                                }
                                                catch (InputMismatchException e)
                                                {
                                                        System.out.println("Kindly Enter a valid option");
                                                        System.out.println("");
                                                        sc.nextLine();
                                                }

                                        }


                                        creator.UpdateCreatedCourses(course);
                                        topic.UpdateCourses(course);

                                }
                                break;

                                case 5:flag = false;
                                        break;

                                default: System.out.println("Enter a Valid option");
                                        break;



                        }
                }

        }

        public void loggedInAsCreator(Creator creator)
        {
                boolean flag = true;
                while(flag)
                {
                        Scanner sc = new Scanner(System.in);
                        System.out.println("");
                        System.out.println("1.create a Course");
                        System.out.println("2.View Summary");
                        System.out.println("3.Log Out");
                        int homePageOption;
                        try
                        {
                                homePageOption = sc.nextInt();
                        }
                        catch (InputMismatchException e)
                        {
                                System.out.println("Kindly Enter a valid option");
                                System.out.println("");
                                continue;
                        }

                        switch (homePageOption) {
                                case 1: {
                                        Category category;
                                        int categoryId;
                                        while(true)
                                        {

                                                try
                                                {
                                                        printCategories();
                                                        System.out.println("");
                                                        System.out.println("Enter a Category");

                                                        categoryId = sc.nextInt();
                                                        category = getCategory(categoryId);
                                                        break;
                                                }
                                                catch (NullPointerException e)
                                                {
                                                        System.out.println("Kindly Enter a valid option");
                                                        System.out.println("");
                                                }
                                                catch (InputMismatchException e)
                                                {
                                                        System.out.println("Kindly Enter a valid option");
                                                        System.out.println("");
                                                        sc.nextLine();
                                                }


                                        }

                                        int topicId;
                                        Topic topic;
                                        while(true)
                                        {
                                                try
                                                {
                                                        category.printTopics();
                                                        System.out.println("");
                                                        System.out.println("Enter a Topic");

                                                        topicId = sc.nextInt();
                                                        topic = category.getTopic(topicId);
                                                        break;

                                                }
                                                catch (NullPointerException e)
                                                {
                                                        System.out.println("Kindly Enter a valid option");
                                                        System.out.println("");
                                                }
                                                catch (InputMismatchException e)
                                                {
                                                        System.out.println("Kindly Enter a valid option");
                                                        System.out.println("");
                                                        sc.nextLine();
                                                }

                                        }

                                        String courseName;
                                        while(true)
                                        {
                                                System.out.print("Enter your new CourseName : ");
                                                sc.nextLine();
                                                courseName = sc.nextLine();
                                                if(allCourses.containsKey(courseName))
                                                {
                                                        System.out.println("Sorry !!! A Course already exists with this name try some other name");
                                                }
                                                break;
                                        }

                                        createCourse(categoryId, topicId, creator.getCreatorId(), courseName);
                                        topic.printCourses();
                                        System.out.println("Course Created Successfully !!!");
                                        System.out.println("");
                                }
                                break;

                                case 2: {
                                        creator.printCreatedCourses();
                                }
                                break;

                                case 3: flag = false;
                                        break;

                                default:System.out.println("Enter a Valid option");
                                break;

                        }
                }

        }

        public Creator getCreator(String creatorId)
        {
                return instructors.get(creatorId);
        }


        public void addCategory(Integer id,String name)
        {
                categories.put(id,new Category(name));
        }


        public Category getCategory(int index)
        {
                Category category= categories.get(index);
                if(category == null)
                        throw new NullPointerException();
                return category;

        }

        public Course getCourse(String name)
        {
                Course course =  allCourses.get(name);
                if(course == null)
                {
                        throw new NullPointerException();
                }
                return course;
        }

        public void printCategories()
        {
                System.out.println("CATEGORIES");
                for(Map.Entry m : categories.entrySet()){
                        System.out.println("            "+m.getKey()+". "+m.getValue());
                }
        }

        public void printInstructors()
        {
                System.out.println("INSTRUCTORS");
                for(Map.Entry m : instructors.entrySet()){
                        System.out.println("            "+m.getValue());
                }
        }





        public void createCourse(int categoryId,int topicId,String creatorId,String name)
        {
                Creator creator = getCreator(creatorId);
                Course newCourse = getCategory(categoryId).getTopic(topicId).addCourse(name,creator,topicId,categoryId);
                allCourses.put(name, newCourse);
                creator.addToCreatedCourses(newCourse);

        }

        public void buyCourse(String courseName,User user)
        {
                Course newCourse = allCourses.get(courseName);
                newCourse.incrementNumberOfUsers();
                user.addCourseToMyCourses(newCourse);
        }



        public void test()
        {
                users.put("dinesh123",new User("Dinesh","qwer","dinesh123"));
                users.put("ram123",new User("Ram","ram123","ram123"));
                instructors.put("kumar123",new Creator("kumar","5151","kumar123"));
                instructorNames.put("kumar","kumar123");
        }
}


