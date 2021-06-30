package com.collections;

import java.util.*;

public class Creator extends Client
{

    private String name;
    private String creatorId;
    private String password;
    private final HashMap<Integer,Course> createdCourses;

    public Creator(String name, String password, String creatorId) {
        this.name = name;
        this.creatorId = creatorId;
        this.password = password;
        this.createdCourses = new HashMap<>();
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


    public String getPassword() {
        return password;
    }



    public void addToCreatedCourses(Course course,int courseId)
    {
        createdCourses.put(courseId,course);
    }




    public void removeFromCreatedCourses(Course course)
    {
        createdCourses.remove(course);

    }

    public void printCreatedCourses()
    {
        System.out.println("COURSES");
        for(Map.Entry m : createdCourses.entrySet())
        {

            Course course = (Course) m.getValue();
            if(course.getRating() >= 4.5f)
            {
                System.out.println("        FEATURED COURSE !!!");
                System.out.println("            "+m.getValue());
            }

        }

        for(Map.Entry m : createdCourses.entrySet())
        {
            Course course = (Course) m.getValue();
            if(course.getRating() < 4.5f)
            {
                System.out.println("            "+m.getValue());
            }
        }



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



    @Override
    public int hashCode() {
        return creatorId.hashCode();
    }


    @Override
    public boolean equals(Object obj) {
        if(obj == this)
        {
            return true;
        }
        else if(!(obj instanceof Creator))
        {
            return false;
        }
        else
        {
            Creator creator = (Creator) obj;

            return creator.getCreatorId().equals(creatorId) && creator.getPassword().equals(password);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
