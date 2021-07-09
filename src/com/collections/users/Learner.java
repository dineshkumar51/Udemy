package com.collections.users;

import java.util.HashMap;
import com.collections.udemy.Course;
import com.collections.exceptions.InvalidPasswordException;


public class Learner implements User
{

        private int Id;
        private String userName;
        private String name;
        private String password;
        private final HashMap<Integer,Course> courses;
        private final HashMap<Integer,Course> wishList;
        private static int noOfLearners;

        public Learner(String name, String password, String userName)
        {
                this.Id = ++noOfLearners;
                this.userName = userName;
                this.name = name;
                this.password = password;
                this.courses = new HashMap<>();
                this.wishList = new HashMap<>();
        }

        @Override
        public int getId() {
                return Id;
        }

        @Override
        public void setId(int id) {
                Id = id;
        }

        @Override
        public String getUserName() {
                return userName;
        }

        @Override
        public void setUserName(String userName) {
                this.userName = userName;
        }

        @Override
        public String getName() {
                return name;
        }

        @Override
        public void setName(String name) {
                this.name = name;
        }

        public void addToCourses(Course course)
        {
                courses.put(course.getId(),course);
        }

        public void addCourseToWishlist(Course course)
        {
                wishList.put(course.getId(),course);
        }

        public void printCourses()
        {
                System.out.println("MY COURSES"+"\n");
                courses.forEach((key, value) -> System.out.println(value));
                System.out.println();
        }

        public void printWishlist()
        {
                wishList.forEach((key, value) -> System.out.println(value));
                System.out.println();
        }

        @Override
       public void changePassword(String oldPassword, String newPassword) throws InvalidPasswordException
       {
               if(!oldPassword.equals(this.password))
               {
                        throw new InvalidPasswordException("Incorrect Password");
               }

               else
               {
                       this.password = newPassword;
               }
       }

        public String getPassword() {
                return password;
        }


        @Override
        public int hashCode() {
                return userName.hashCode();
        }


        @Override
        public boolean equals(Object obj) {
                if(obj == this)
                {
                        return true;
                }
                else if(!(obj instanceof Learner learner))
                {
                        return false;
                }
                else
                {
                        return learner.getUserName().equals(userName) && learner.getPassword().equals(password);
                }
        }


        @Override
        public String toString() {
                return name;
        }
}
