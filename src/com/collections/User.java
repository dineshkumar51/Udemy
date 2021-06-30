package com.collections;

import java.util.*;

public class User extends Client
{
        private String userId;
        private String name;
        private String password;
        private final HashMap<String,Course> myCourses;
        private final HashMap<String,Course> wishList;


        public User(String name, String password, String userId)
        {
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

        public void addCourseToMyCourses(Course course)
        {
                myCourses.put(course.getName(),course);
        }

        public void addCourseToWishlist(Course course)
        {
                wishList.put(course.getName(),course);
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
                return userId.hashCode();
        }


        @Override
        public boolean equals(Object obj) {
                if(obj == this)
                {
                        return true;
                }
                else if(!(obj instanceof User))
                {
                        return false;
                }
                else
                {
                        User user = (User) obj;

                        return user.getUserId().equals(userId) && user.getPassword().equals(password);
                }
        }


        @Override
        public String toString() {
                return name;
        }
}
