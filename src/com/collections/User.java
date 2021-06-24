package com.collections;

import java.util.*;

public class User
{
        private String userId;
        private String name;
        private String password;
        private HashMap<String,Course> myCourses;
        private HashMap<String,Course> wishList;


        public User(String name, String password, String userId) {
                this.userId = userId;
                this.name = name;
                this.password = password;
                this.myCourses = new HashMap<>();
                this.wishList = new HashMap<>();
        }

        public String getUserId() {
                return userId;
        }

        public void setUserId(String userId) {
                this.userId = userId;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public void addCourse(Course course)
        {
                myCourses.put(course.getName(),course);
        }

        public void addCourseToWishlist(Course course)
        {
                myCourses.put(course.getName(),course);
        }

        public void printMycourses()
        {
                for(Map.Entry m : myCourses.entrySet()){
                        System.out.println(m.getKey());
                }
                System.out.println("");
        }

        public void printWishlist()
        {
                for(Map.Entry m : wishList.entrySet()){
                        System.out.println(m.getKey());
                }
                System.out.println("");
        }

       public void changePassword(String oldPassword, String newPassword) throws InvalidPasswordException
       {
               if(!oldPassword.equals(this.password))
               {
                        throw new InvalidPasswordException();
               }
               else
               {
                       this.password = newPassword;
               }
       }

        public String getPassword() {
                return password;
        }
}
