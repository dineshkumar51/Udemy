package com.collections.users;

import com.collections.udemy.Course;
import com.collections.exceptions.InvalidPasswordException;
import java.util.HashMap;
import java.util.Map;


public class Creator implements User
{


    private int Id;
    private String name;
    private String userName;
    private String password;
    private final HashMap<Integer, Course> courses;
    private static int noOfCreators;

    public Creator(String name, String password, String userName) {
        this.Id = ++noOfCreators;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.courses = new HashMap<>();
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
    public String getName() {
        return name;
    }


    @Override
    public void setName(String name) {
        this.name = name;
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
    public String getPassword() {
        return password;
    }



    public void addToCourses(Course course, int courseId)
    {
        courses.put(courseId,course);
    }



    public void printCourses()
    {
        System.out.println("COURSES");
        courses.forEach((key, value) -> {

            Course course = (Course) value;
            if (course.getRating() >= 4.5f) {
                System.out.println("        FEATURED COURSE !!!");
                System.out.println(value);
                System.out.println();
            }

        });

        for(Map.Entry m : courses.entrySet())
        {
            Course course = (Course) m.getValue();
            if(course.getRating() < 4.5f)
            {
                System.out.println(m.getValue());
                System.out.println();
            }
        }



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
        else if(!(obj instanceof Creator))
        {
            return false;
        }
        else
        {
            Creator creator = (Creator) obj;

            return creator.getUserName().equals(userName) && creator.getPassword().equals(password);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
