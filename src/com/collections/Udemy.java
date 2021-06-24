package com.collections;

import java.util.*;

public class Udemy
{
        private HashMap<String,User> users;
        private HashMap<String,Creator> instructors;
        private HashMap<String,Course> allCourses;
        private HashMap<Integer,Category> categories;


        public Udemy() {
                users = new HashMap<>();
                instructors = new HashMap<>();
                categories = new HashMap<>();
                allCourses = new HashMap<>();
        }

        public Object login() throws InvalidUserIdOrPasswordException
        {
                Scanner sc = new Scanner(System.in);
                System.out.println("1.Login as User");
                System.out.println("2.Login as Creator");

                int check = sc.nextInt();

                if(check == 1)
                {
                        System.out.print("Enter your UserId : ");
                        String userId = sc.next();
                        System.out.print("Enter your Password : ");
                        String password = sc.next();

                        if(users.containsKey(userId))
                        {
                                String correctPassword = users.get(userId).getPassword();
                                if(correctPassword.equals(password))
                                {
                                        System.out.println("Welcome, "+users.get(userId).getName());
                                        return users.get(userId);
                                }
                        }
                        //sc.close();
                        throw new InvalidUserIdOrPasswordException();

                }
                else
                {
                        System.out.print("Enter your CreatorId : ");
                        String creatorId = sc.next();
                        System.out.print("Enter your Password : ");
                        String password = sc.next();

                        if(instructors.containsKey(creatorId))
                        {
                                String correctPassword = instructors.get(creatorId).getPassword();
                                if(correctPassword.equals(password))
                                {
                                        System.out.println("Welcome, "+instructors.get(creatorId).getName());
                                        return instructors.get(creatorId);
                                }
                        }
                        //sc.close();
                        throw new InvalidUserIdOrPasswordException();
                }

        }

        public void signup() throws UserIdAlreadyExistException
        {
                Scanner sc = new Scanner(System.in);
                System.out.println("1.SignUp as User");
                System.out.println("2.SignUp as Creator");

                int check = sc.nextInt();

                if(check == 1)
                {
                        System.out.print("Enter your name : ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        System.out.print("Enter userId : ");
                        String userId = sc.next();
                        System.out.print("Enter password : ");
                        String password = sc.next();

                        if(!users.containsKey(userId))
                        {
                                User newUser = new User(name,password,userId);
                                users.put(userId,newUser);
                                System.out.println("Account Created Successfully");
                        }
                        else
                        {
                                //sc.close();
                                throw new UserIdAlreadyExistException();
                        }

                }
                else
                {
                        System.out.print("Enter your name : ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        System.out.print("Enter creatorId : ");
                        String creatorId = sc.next();
                        System.out.print("Enter password : ");
                        String password = sc.next();

                        if(!instructors.containsKey(creatorId))
                        {
                                Creator newCreator = new Creator(name,password,creatorId);
                                instructors.put(creatorId,newCreator);
                                System.out.println("Account Created Successfully");

                        }
                        else
                        {
                                //sc.close();
                                throw new UserIdAlreadyExistException();
                        }


                }
                //sc.close();


        }

        public void addCategory(Integer id,String name)
        {
                categories.put(id,new Category(name));
        }


        public Category getCategory(int index)
        {
                return categories.get(index);
        }


        public void printCategories()
        {
                for(Map.Entry m : categories.entrySet()){
                        System.out.println(m.getKey()+". "+m.getValue());
                }
        }




        public void createCourse(int categoryIndex,int topicId,String creatorId,String name)
        {
                Creator creator = getCreator(creatorId);
                Course newCourse = getCategory(categoryIndex).getTopic(topicId).addCourse(name,creator);
                allCourses.put(name, newCourse);
                creator.addToCreatedCourses(newCourse);

        }

        public Creator getCreator(String creatorId)
        {
                return instructors.get(creatorId);
        }

        public Course getCourse(String name)
        {
                return allCourses.get(name);
        }

        public void buyCourse(String courseName,User user)
        {
                Course newCourse = allCourses.get(courseName);
                newCourse.incrementNumberOfUsers();
                user.addCourse(newCourse);
        }


        public void test()
        {
                users.put("dinesh123",new User("Dinesh","qwer","dinesh123"));
                users.put("rish123",new User("Rishaban","rish123","rish123"));
                instructors.put("kumar123",new Creator("kumar","5151","kumar123"));
        }
}


