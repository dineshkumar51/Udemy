package com.collections;

import java.util.*;

public class Creator
{
    private String name;
    private String creatorId;
    private String password;
    private LinkedList<Course> createdCourses;

    public Creator(String name, String password, String creatorId) {
        this.name = name;
        this.creatorId = creatorId;
        this.password = password;
        this.createdCourses = new LinkedList<>();
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



    public void addToCreatedCourses(Course course)
    {
        createdCourses.addLast(course);
    }

    public void UpdateCreatedCourses(Course course)
    {
        Course firstCourse = createdCourses.getFirst();
        Course lastCourse = createdCourses.getLast();

        if(course.getRating() >= firstCourse.getRating())
        {
            createdCourses.addFirst(course);
            return;
        }

        if(course.getRating() <= lastCourse.getRating())
        {
            createdCourses.addLast(course);
            return;
        }

        ListIterator itr = createdCourses.listIterator();

        while(itr.hasNext())
        {
            Course currentCourse = (Course) itr.next();
            if(currentCourse.getRating() <= course.getRating())
            {
                itr.previous();
                itr.add(course);
                return;
            }

        }
    }


    public void removeFromCreatedCourses(Course course)
    {
        createdCourses.remove(course);

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



    public int hashCode() {
        return creatorId.hashCode();
    }


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

    public String toString() {
        return name;
    }
}
