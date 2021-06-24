package com.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class Topic
{

    private String name;
    private ArrayList<Course> courses;


    public Topic(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

   public Course addCourse(String name,Creator creator)
    {
        Course newCourse = new Course(name,creator);
        courses.add(newCourse);
        return newCourse;
    }

    public void printCourses()
    {
        Iterator<Course> itr = courses.iterator();

        while(itr.hasNext())
        {
            System.out.println(itr.next());
            System.out.println("");
        }

    }

    public String getName() {
        return name;
    }


    public String toString() {
        return name;
    }
}
