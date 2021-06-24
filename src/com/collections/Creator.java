package com.collections;

import java.util.*;

public class Creator
{
    private String name;
    private String creatorId;
    private String password;
    private TreeSet<Course> createdCourses;

    public Creator(String name, String password, String creatorId) {
        this.name = name;
        this.creatorId = creatorId;
        this.password = password;
        this.createdCourses = new TreeSet<>();
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getCreatorId() {
        return creatorId;
    }


    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }


    public void addToCreatedCourses(Course course)
    {
        createdCourses.add(course);
    }

    public void printCreatedCourses()
    {
        Iterator<Course> itr = createdCourses.iterator();

        while(itr.hasNext())
        {
            System.out.println(itr.next());
            System.out.println("");
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

    public String toString() {
        return name;
    }
}
